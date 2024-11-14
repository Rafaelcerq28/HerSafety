package com.hersafety.hersafety.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hersafety.hersafety.model.User;
import com.hersafety.hersafety.repository.UserRepository;

@Service
public class SafetyTipsService {

    UserRepository userRepository;

    public SafetyTipsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<String> getSafetyTips(String username){

        Optional<User> u = userRepository.findByUsername(username);    

        String testReturn = "";
        try {
            testReturn = safetyTipsGenerator(u.get());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ResponseEntity.ok().body(testReturn);
    }

    //CLASS RESPONSABLE FOR GENERATE AI RESPONSES
    public String safetyTipsGenerator(User user) throws IOException, InterruptedException{
        long startTime;
        long endTime;
        long executionTime; 

        startTime = System.currentTimeMillis();

        System.out.println(user.getSecurityInfo().getQuestion1());
        String system = "You are a safety expert providing personalized safety tips for women based on their social habits and preferences related to nightlife.";
        String content = "Based on the following answers about a user's nightlife habits, provide personalized safety tips:\n -"+ 
        "**How often do you go to bars or clubs?** Answer: Rarely\n - **What type of place do you usually visit?**"+
        " Answer: "+user.getSecurityInfo().getQuestion1() +"\n - **Do you usually go out alone or with company?** Answer: "+user.getSecurityInfo().getQuestion2()+"\n "+
      "- **How do you usually get home after going out?** Answer: "+user.getSecurityInfo().getQuestion3()+"\n "+
      "- **Have you ever experienced a risky situation in bars or clubs?** Answer: "+user.getSecurityInfo().getQuestion4()+"\n\n"+
      "Using these answers, generate a safety advice for this user, addressing potential concerns about nightlife safety, transportation after a night out, and ways to stay safe while in a group.";
        // Substitua pela sua chave de API
        String apiKey = "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";
        // String apiKey = "";
        // Configura o endpoint da API
        String apiEndpoint = "https://api.openai.com/v1/chat/completions";
        
        // Define o modelo e a mensagem para a API
        JSONObject requestBody = new JSONObject();
        requestBody.put("model", "gpt-4o-mini");
        requestBody.put("temperature", 0.7);
        
        // Define as mensagens no formato requerido
        requestBody.put("messages", new JSONArray()
            .put(new JSONObject().put("role", "system").put("content", system))
            .put(new JSONObject().put("role", "user").put("content", content))
        );

        // Cria a requisição HTTP com o método POST
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(apiEndpoint))
            .header("Content-Type", "application/json")
            .header("Authorization", "Bearer " + apiKey)
            .POST(HttpRequest.BodyPublishers.ofString(requestBody.toString()))
            .build();

            System.out.println("REQUEST " + request);
        // Envia a requisição
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String reply = "";
        // Checa a resposta
        if (response.statusCode() == 200) {
            JSONObject jsonResponse = new JSONObject(response.body());
            reply = jsonResponse.getJSONArray("choices").getJSONObject(0).getJSONObject("message").getString("content");
            System.out.println("Resposta da API: " + reply);
        } else {
            System.out.println("Erro: " + response.statusCode() + " - " + response.body());
        }
        // System.out.println("REPLY: \n\n " + reply);
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        System.out.println("Execution time: " + executionTime + "ms - " + (executionTime/1000) +"s");
        System.out.println();

        return response.toString() + "\n" + reply;
    }
}
