package com.SpringLearnRedV2.Controller;
import io.github.flashvayne.chatgpt.service.ChatgptService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/Chatbot")
public class Question_Controller {
	 @Autowired
	private   ChatgptService chatgptService;
 
	
	 @GetMapping("/chat")
	 public String send(@RequestParam String message) {
		 
		 
		 String responseMessage = chatgptService.sendMessage(message);
		 
		 
		 
		 return responseMessage;
	 }
}
