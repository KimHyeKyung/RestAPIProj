package com.kosta.rest.ex1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController	//Spring3(@Controller+@ResponseBody)
@RequestMapping("/test/*")
public class TestController {
	
	@RequestMapping("/hello")
	public ResponseEntity<String> hello() {
		return new ResponseEntity<String>("Hello REST!!", HttpStatus.OK);
	}
	
	@GetMapping("/member")
	public ResponseEntity<Member> member() {
		Member mem = new Member();
		mem.setId("hong");
		mem.setName("홍길동");
		mem.setPassword("1234");
		mem.setEmail("hong@kosta.com");
		return new ResponseEntity<Member>(mem, HttpStatus.OK);
	}
	
	@GetMapping("/employee")
	public ResponseEntity<Employee> employee() {
		Department department = new Department();
		department.id="101";
		department.name="인사과";
		Employee emp = new Employee();
		emp.department = department;
		emp.id="h1000";
		emp.name="홍길동";
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
	
	@GetMapping("/memberList")
	public ResponseEntity<List<Member>> memberList(){
		List<Member> memList = new ArrayList<>();
		memList.add(new Member("hong","1234","홍길동","hong@kosta.com"));
		memList.add(new Member("go","1234","고길동","go@kosta.com"));
		memList.add(new Member("song","1234","송길동","song@kosta.com"));
		return new ResponseEntity<List<Member>>(memList, HttpStatus.OK);
	}
	
	@GetMapping("/memberMap")
	public ResponseEntity<Map<Integer,Member>> memberMap(){
		Map<Integer,Member> map = new HashMap<>();
		for(int i=0; i<10; i++) {
			Member m = new Member("100"+i,"123"+i,"hong"+i,"hong"+i+"kosta.com");
			map.put(i, m);
		}
		return new ResponseEntity<Map<Integer,Member>>(map, HttpStatus.OK);
	}
	
	@GetMapping("/res")
	public ResponseEntity<String> res() {
		HttpHeaders responseHeader = new HttpHeaders();
		responseHeader.add("Content-Type", "text/html; charset=utf-8");
		String message = "<script>";
		message += "alert('새 회원을 등록합니다.');";
		message += "location.href='/test/memberList';";
		message += "</script>";
		return new ResponseEntity<String>(message, responseHeader, HttpStatus.CREATED);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
