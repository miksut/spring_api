package com.example.springapi;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MessageController {

    private final MessageRepository repository;
    private final String defaultGreeting = "Hello, ";
    private final String defaultName = "User";

    private final Message findOrStore(String name) {
        return repository.findByContent(defaultGreeting + name).orElseGet(() -> {
            return repository.save(new Message(defaultGreeting + name));
        });
    }

    public MessageController(MessageRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/greeting")
    @CrossOrigin(origins="http://localhost:3000")
    public Message greeting(@RequestParam(value = "name", defaultValue = defaultName) String name) {
        if(name.equalsIgnoreCase(defaultName)) {
            Long id = Long.valueOf(1);
            return repository.findByContent(defaultGreeting + defaultName).get();
        }
        return findOrStore(name);
    }

    @PostMapping("/greeting")
    public Message store(@RequestBody String name) {
        return findOrStore(name);
    }
}
