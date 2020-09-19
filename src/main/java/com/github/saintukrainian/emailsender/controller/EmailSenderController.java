package com.github.saintukrainian.emailsender.controller;

import javax.validation.Valid;

import com.github.saintukrainian.emailsender.sender.Sender;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailSenderController {

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("sender", new Sender());
        return "home";
    }

    @PostMapping("/process")
    public String process(@Valid @ModelAttribute("sender") Sender sender, BindingResult result) {
        if(result.hasErrors()) {
            return "home";
        } else {
            sender.sendEmail(sender);
            return "success";
        }
    }
    
}
