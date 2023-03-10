package com.tsv.implementation.dao;

import com.tsv.implementation.Entity.MessageCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageCountRepository extends JpaRepository<MessageCount , Integer>
{
      MessageCount findByUserName(String userName);
}
