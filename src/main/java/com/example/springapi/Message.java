package com.example.springapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Message {
    private @Id @GeneratedValue Long id;
    private String content;

    public Message() {};

    public Message(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(!(o instanceof Message))
            return false;
        Message msg = (Message) o;
        return Objects.equals(this.id, msg.id) && Objects.equals(this.content, msg.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.content);
    }

    @Override
    public String toString() {
        return "Message{" + "id: " + this.id + ", content: " + this.content + "}";
    }
}
