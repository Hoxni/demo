package com.example.demo.order;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Embeddable
public class Client{

    /*@Id
    @GeneratedValue
    public Long id;*/

    private String email;
    private String name;

    public Client(){
        this.email = "";
        this.name = "";
    }

    public Client(String email, String name) {
        this.email = email;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Client " + name + " " + email;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }
}
