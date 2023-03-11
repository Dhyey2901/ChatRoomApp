package com.tsv.implementation.service;

import com.tsv.implementation.Entity.MessageCount;

import java.util.List;

public interface MessageCountServie
{
   public String validateFromDatabase(MessageCount messageCount);
   public List<MessageCount> getRank();
}
