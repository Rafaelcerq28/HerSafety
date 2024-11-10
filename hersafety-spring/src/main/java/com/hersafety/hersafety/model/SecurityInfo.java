package com.hersafety.hersafety.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="security_info")
public class SecurityInfo {

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String question1;
    private String question2;
    private String question3;
    private String question4;
    private String question5;
       
    public String getQuestion1() {
        return question1;
    }
    public void setQuestion1(String question1) {
        this.question1 = question1;
    }
    public String getQuestion2() {
        return question2;
    }
    public void setQuestion2(String question2) {
        this.question2 = question2;
    }
    public String getQuestion3() {
        return question3;
    }
    public void setQuestion3(String question3) {
        this.question3 = question3;
    }
    public String getQuestion4() {
        return question4;
    }
    public void setQuestion4(String question4) {
        this.question4 = question4;
    }
    public String getQuestion5() {
        return question5;
    }
    public void setQuestion5(String question5) {
        this.question5 = question5;
    }
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public void newSecInfo(){
        this.question1 = "";
        this.question2 = "";
        this.question3 = "";
        this.question4 = "";
        this.question5 = "";
    }
    @Override
    public String toString() {
        return "SecurityInfo [id=" + id + ", question1=" + question1 + ", question2=" + question2 + ", question3="
                + question3 + ", question4=" + question4 + ", question5=" + question5 + "]";
    }





    

}
