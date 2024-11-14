package com.hersafety.hersafety.model.OpenAPIResponse;

public class TokensDetails {
    private int cachedTokens;
    private int audioTokens;
    private int reasoningTokens;
    private int acceptedPredictionTokens;
    private int rejectedPredictionTokens;
    
    public int getCachedTokens() {
        return cachedTokens;
    }
    public void setCachedTokens(int cachedTokens) {
        this.cachedTokens = cachedTokens;
    }
    public int getAudioTokens() {
        return audioTokens;
    }
    public void setAudioTokens(int audioTokens) {
        this.audioTokens = audioTokens;
    }
    public int getReasoningTokens() {
        return reasoningTokens;
    }
    public void setReasoningTokens(int reasoningTokens) {
        this.reasoningTokens = reasoningTokens;
    }
    public int getAcceptedPredictionTokens() {
        return acceptedPredictionTokens;
    }
    public void setAcceptedPredictionTokens(int acceptedPredictionTokens) {
        this.acceptedPredictionTokens = acceptedPredictionTokens;
    }
    public int getRejectedPredictionTokens() {
        return rejectedPredictionTokens;
    }
    public void setRejectedPredictionTokens(int rejectedPredictionTokens) {
        this.rejectedPredictionTokens = rejectedPredictionTokens;
    }

    
}
