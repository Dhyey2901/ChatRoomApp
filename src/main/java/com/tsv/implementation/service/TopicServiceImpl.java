package com.tsv.implementation.service;

import com.tsv.implementation.Entity.Link;
import com.tsv.implementation.dao.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class TopicServiceImpl implements TopicService{


    @Autowired
    LinkRepository linkRepository;
    @Override
    public String addTopic(String topic)
    {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        UserDetails user = (UserDetails)securityContext.getAuthentication().getPrincipal();
        Link lo = linkRepository.findByHostName(user.getUsername());
        if(lo != null)
        {
            lo.setTopic(topic);
            linkRepository.save(lo);
            return "success";
        }
        return "error";
    }
}
