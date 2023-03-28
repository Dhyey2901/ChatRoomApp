package com.tsv.implementation.dao;

import com.tsv.implementation.Entity.MessageCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageCountRepository extends JpaRepository<MessageCount , Integer>
{
      MessageCount findByUserName(String userName);
      List<MessageCount> findAllByOrderByMessageCountDesc();//orderByCountDec();


     // MessageCount getReferenceByUserName(String mail);
}
