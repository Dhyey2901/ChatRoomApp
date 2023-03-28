package com.tsv.implementation.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MessageCount
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String userName;
    private int messageCount;



    private int link;

    public int getLink() {
        return link;
    }

    public void setLink(int link) {
        this.link = link;
    }

    public MessageCount() {
    }

    public MessageCount(String userName, int messageCount) {
        this.userName = userName;
        this.messageCount = messageCount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getMessageCount() {
        return messageCount;
    }

    public void setMessageCount(int messageCount) {
        this.messageCount = messageCount;
    }
}
