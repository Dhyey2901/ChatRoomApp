package com.tsv.implementation.dao;

import com.tsv.implementation.Entity.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkRepository extends JpaRepository<Link, Integer>
{
    Link findByHostName(String email);

    Link findByLink(int data);
}
