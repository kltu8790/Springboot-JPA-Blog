package com.alice.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {
	
	//http://localhost:8000/blog/temp/home
	@GetMapping
	public String tempHome() {
		System.out.println("tempHome()");
		// 파일 리턴 기본경로 : src/main/resources/static 
		// 리턴명 : /home.html
		// 풀경로 : src/main/resources/static/home.html
		return "/home.html";
	}
	
	@GetMapping("/temp/img")
	public String tempimg() {
		return "/587f22fb34d19ec81f931ca83ff354dc.png";
	}
	
	@GetMapping("/temp/jsp")
	public String tempJsp() {
		//prefix : /WEB-INF/views/
		// suffix : .jsp
		// 풀네임: /WEB-INF/views/test.jsp
		return "test";
	}
	
}
