package com.hersafety.hersafety.model.OpenAPIResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Usage {
    private int promptTokens;
    @JsonIgnoreProperties
    private int completionTokens;
    private int totalTokens;
    private TokensDetails promptTokensDetails;
    private TokensDetails completionTokensDetails;
    
    public int getPromptTokens() {
        return promptTokens;
    }
    public void setPromptTokens(int promptTokens) {
        this.promptTokens = promptTokens;
    }
    public int getCompletionTokens() {
        return completionTokens;
    }
    public void setCompletionTokens(int completionTokens) {
        this.completionTokens = completionTokens;
    }
    public int getTotalTokens() {
        return totalTokens;
    }
    public void setTotalTokens(int totalTokens) {
        this.totalTokens = totalTokens;
    }
    public TokensDetails getPromptTokensDetails() {
        return promptTokensDetails;
    }
    public void setPromptTokensDetails(TokensDetails promptTokensDetails) {
        this.promptTokensDetails = promptTokensDetails;
    }
    public TokensDetails getCompletionTokensDetails() {
        return completionTokensDetails;
    }
    public void setCompletionTokensDetails(TokensDetails completionTokensDetails) {
        this.completionTokensDetails = completionTokensDetails;
    }

    
}
