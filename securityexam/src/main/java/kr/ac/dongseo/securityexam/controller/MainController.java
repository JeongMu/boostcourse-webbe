package kr.ac.dongseo.securityexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	@RequestMapping("/main")
	@ResponseBody
	public String main() {
		return "main page"; // 페이지가 아닌 그냥 문자열 자체가 응답결과로 나옴
	}
	
	@RequestMapping("/securepage")
	@ResponseBody
	public String securitypage() {
		return "secure page";
	}
}
