package com.example.livreson.controller;
import com.example.livreson.Model.Client;
import com.example.livreson.service.servicelmp.ClientServicelmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Optional;

@Controller
public class LoginController {
    @Autowired
    ClientServicelmp userService;


    // handler method to handle home page request


    // handler method to handle user registration form request
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        // create model object to store form data
        Client user = new Client(  );
        model.addAttribute("user", user);
        return "register";
    }

    // handler method to handle home page request
    @GetMapping("/index")
    public String home(){
        return "index";
    }

    // handler method to handle user registration form request


    // handler method to handle user registration form submit request
    @PostMapping("/register/save")
    public String registration(@Validated @ModelAttribute("user") Client userDto,
                               BindingResult result,
                               Model model){
        Optional<Optional<Client>> existingUser = userService.findClientByemailCl(userDto.getEmailCl());

        if (existingUser.isPresent() && existingUser.get().get( ).getEmailCl( ) != null && !existingUser.get().get().getEmailCl().isEmpty()) {
            result.rejectValue("email", null, "There is already an account registered with the same email");
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }

        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "/register";
        }

        userService.saveClient(userDto);
        return "redirect:/register?success";
    }

}
