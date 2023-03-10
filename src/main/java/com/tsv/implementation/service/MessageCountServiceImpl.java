package com.tsv.implementation.service;

import com.tsv.implementation.Entity.MessageCount;
import com.tsv.implementation.Entity.User;
import com.tsv.implementation.dao.ChatMessageRepository;
import com.tsv.implementation.dao.MessageCountRepository;
import com.tsv.implementation.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MessageCountServiceImpl implements MessageCountServie
{
    @Autowired
    UserRepository userRepository;
    @Autowired
    MessageCountRepository messageCountRepository;

    @Override
    public String validateFromDatabase(MessageCount messageCount)   //throws  UsernameNotFoundException
    {
        User user  = userRepository.findByEmail(messageCount.getUserName());
        if(user == null) {
           // throw new UsernameNotFoundException("Invalid username or password.");
            return  "failure";
        }
        else
        {
            messageCount.setMessageCount(0);
            messageCountRepository.save(messageCount);
            return "success";
        }

    }
}
