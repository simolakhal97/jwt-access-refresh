package com.example.livreson.service.servicelmp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Component

public class MessageServicelmp {
/*
    private MessageMapper messageMapper;

    private List<ChatMessage> chatMessages;

    @PostConstruct
    public void postConstruct() {
        System.out.println("Creating MessageService bean");
        this.chatMessages = new ArrayList<>();
    }



    public void addMessage(ChatForm chatForm) {
        ChatMessage newMessage = new ChatMessage();
        newMessage.setUsername(chatForm.getUsername());
        switch (chatForm.getMessageType()) {
            case "Say" : newMessage.setMessageText(chatForm.getMessageText());
            case "Shout" : newMessage.setMessageText(chatForm.getMessageText().toUpperCase());
            case "Whisper" : newMessage.setMessageText(chatForm.getMessageText().toLowerCase());
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + chatForm.getMessageType( ));
        }
        messageMapper.insert(newMessage);
    }

    public List<ChatMessage> getChatMessages() {
        return messageMapper.getMessages();
    }*/
}
