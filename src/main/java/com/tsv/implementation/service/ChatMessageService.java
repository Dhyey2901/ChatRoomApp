package com.tsv.implementation.service;

//import com.chat.app.chatroomapp.App.Dao.ChatMessageRepository;
//import com.chat.app.chatroomapp.App.Entity.ChatMessage;
import com.tsv.implementation.dao.ChatMessageRepository;
import  com.tsv.implementation.Entity.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatMessageService {
    @Autowired
    private  ChatMessageRepository chatMessageRepository;

  public ChatMessageService()
    {

    }

    public ChatMessageService(ChatMessageRepository chatMessageRepository) {
        this.chatMessageRepository = chatMessageRepository;
    }

    public List<ChatMessage> getMessagesForGroup(long groupId) {
        return chatMessageRepository.findByGroupIdOrderByTimestampAsc(groupId);
    }

    public void saveMessage(ChatMessage message) {
        chatMessageRepository.save(message);
    }
}