package com.hersafety.hersafety.model.OpenAPIResponse;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChatCompletionRequest {
    private String model;
    private List<Message> messages;
    private double temperature;
    
    @JsonProperty("max_tokens")
    private int maxTokens;
    
    @JsonProperty("top_p")
    private int topP;
    
    @JsonProperty("frequency_penalty")
    private int frequencyPenalty;
    
    @JsonProperty("presence_penalty")
    private int presencePenalty;
    
    @JsonProperty("response_format")
    private ResponseFormat responseFormat;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getMaxTokens() {
        return maxTokens;
    }

    public void setMaxTokens(int maxTokens) {
        this.maxTokens = maxTokens;
    }

    public int getTopP() {
        return topP;
    }

    public void setTopP(int topP) {
        this.topP = topP;
    }

    public int getFrequencyPenalty() {
        return frequencyPenalty;
    }

    public void setFrequencyPenalty(int frequencyPenalty) {
        this.frequencyPenalty = frequencyPenalty;
    }

    public int getPresencePenalty() {
        return presencePenalty;
    }

    public void setPresencePenalty(int presencePenalty) {
        this.presencePenalty = presencePenalty;
    }

    public ResponseFormat getResponseFormat() {
        return responseFormat;
    }

    public void setResponseFormat(ResponseFormat responseFormat) {
        this.responseFormat = responseFormat;
    }

    // Getters e setters

}
