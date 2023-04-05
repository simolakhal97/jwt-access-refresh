package com.example.livreson.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    /*
    @Autowired
    private MessageServicelmp messageService;
    public MessageController(MessageServicelmp messageService) {
        this.messageService = messageService;
    }
    @GetMapping
    public String getChatPage(ChatForm chatForm, Model model) {
        model.addAttribute("chatMessages", this.messageService.getChatMessages());
        return "chat";
    }
    @PostMapping
    public String postChatMessage(ChatForm chatForm, Model model, Principal principal) {
        chatForm.setUsername(principal.getName());
        this.messageService.addMessage(chatForm);
        chatForm.setMessageText("");
        model.addAttribute("chatMessages", this.messageService.getChatMessages());
        return "redirect:/chat";
    }
    @ModelAttribute("allMessageTypes")
    public String[] allMessageTypes () {
        return new String[] { "Say", "Shout", "Whisper" };
    }
*/
}
