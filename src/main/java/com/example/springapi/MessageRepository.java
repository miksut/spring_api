package com.example.springapi;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface MessageRepository extends JpaRepository<Message, Long> {

    Optional<Message> findByContent(String content);

}
