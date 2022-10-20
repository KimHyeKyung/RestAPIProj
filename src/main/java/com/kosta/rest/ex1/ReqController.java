package com.kosta.rest.ex1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test/*")
public class ReqController {

	@GetMapping("/infoForm")
	public String infoForm() {
		return "JsonTest1";
	}
	
	@ResponseBody
	@PostMapping("/info")
	public String info(@RequestBody Member member) {
		System.out.println(member);
		return "회원정보 등록 성공";
	}
}
