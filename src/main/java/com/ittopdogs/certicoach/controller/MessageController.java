package com.ittopdogs.certicoach.controller;

import com.ittopdogs.certicoach.model.Message;
import com.ittopdogs.certicoach.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class MessageController {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping("/message/{id}")
    public String hello(@PathVariable long id) {
        Optional<Message> message = messageRepository.findById(id);
        return message.map(Message::getContent).orElse("Message not found");
    }

}
