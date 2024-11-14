package com.hersafety.hersafety.model.OpenAPIResponse;

import java.util.List;

public class Message {
    private String role;
    private String content;
    private Object refusal;
    
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Object getRefusal() {
        return refusal;
    }
    public void setRefusal(Object refusal) {
        this.refusal = refusal;
    }

    
}
