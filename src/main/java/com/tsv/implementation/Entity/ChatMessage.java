package com.tsv.implementation.Entity;


//import jakarta.persistence.*;

import javax.persistence.*;
import java.time.LocalDateTime;

//@MappedSuperclass
@Entity
@Table(name = "chat_messages")
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    private long groupId;


    private String senderId;


    private LocalDateTime timestamp;


    private String message;






    public ChatMessage() {
        super();
    }
    public ChatMessage(long groupId, String senderId, LocalDateTime timestamp, String message) {

       super();
        this.groupId = groupId;
        this.senderId = senderId;
        this.timestamp = timestamp;
        this.message = message;
    }



    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
