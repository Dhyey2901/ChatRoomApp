package com.tsv.implementation.service;

import com.tsv.implementation.Entity.Link;
import com.tsv.implementation.Entity.MessageCount;
import com.tsv.implementation.Entity.User;
import com.tsv.implementation.dao.ChatMessageRepository;
import com.tsv.implementation.dao.LinkRepository;
import com.tsv.implementation.dao.MessageCountRepository;
import com.tsv.implementation.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageCountServiceImpl implements MessageCountServie
{
    @Autowired
    LinkRepository linkRepository;
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
            SecurityContext securityContext = SecurityContextHolder.getContext();
            UserDetails users = (UserDetails)securityContext.getAuthentication().getPrincipal();
            Link lo = linkRepository.findByHostName(users.getUsername());
            int link = 0;
            if(lo != null)
            {
                link = lo.getLink();
            }
            messageCount.setLink(link);
            messageCount.setMessageCount(0);
            messageCountRepository.save(messageCount);

            return "success";
        }

    }

    @Override
    public List<MessageCount> getRank() {
        return messageCountRepository.findAllByOrderByMessageCountDesc();     //orderByCountDec();
    }
}
