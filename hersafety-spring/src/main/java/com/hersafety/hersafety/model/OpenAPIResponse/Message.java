package com.hersafety.hersafety.model.OpenAPIResponse;

import java.util.List;

public class Message {
    private String role;
    private List<Content> content;
    
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public List<Content> getContent() {
        return content;
    }
    public void setContent(List<Content> content) {
        this.content = content;
    }

    
}
