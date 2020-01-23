package com.lapaz.treino.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {
	@Value("${welcome.message}")
	private String message;

	private List<String> tasks = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

	//URL = http://localhost:8080/
	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("message", message);
		model.addAttribute("tasks", tasks);
		return "welcome";
	}

	//URL = http://localhost:8080/hello?name=abc
	@GetMapping("/hello")
	public String mainWithParam(@RequestParam(name = "name", required = false, defaultValue = "") String name, Model model) {
		model.addAttribute("message", name);
		return "welcome";
	}

}
