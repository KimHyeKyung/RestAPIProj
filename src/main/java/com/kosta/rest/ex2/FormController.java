package com.kosta.rest.ex2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormController {

	@GetMapping("/boardForm")
	public String boardForm() {
		return "JsonTest2";
	}
}
