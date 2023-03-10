package com.tsv.implementation.dao;

//import com.chat.app.chatroomapp.App.Entity.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import com.tsv.implementation.Entity.ChatMessage;
import org.springframework.stereotype.Repository;

import java.util.List;



//@ComponentScan("com.chat.app.chatroomapp.Dao")

//@Component
@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage,Long>
{
    List<ChatMessage> findByGroupIdOrderByTimestampAsc(long groupId);
}
