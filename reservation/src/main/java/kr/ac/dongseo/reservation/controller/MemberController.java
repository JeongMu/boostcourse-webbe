//package kr.ac.dongseo.reservation.controller;
//
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import kr.ac.dongseo.reservation.service.security.MemberService;
//
//@Controller
////@SuppressWarnings("unused")
//@RequestMapping(path = "/members")
//public class MemberController {
//
//	private final MemberService memberService;
//	private final PasswordEncoder passwordEncoder;
//
//	public MemberController(MemberService memberService, PasswordEncoder passwordEncoder) {
//		this.memberService = memberService;
//		this.passwordEncoder = passwordEncoder;
//	}
//	
//	@GetMapping("/loginform")
//	public String loginform() {
//		return "/members/loginform";
//	}
//	
//	@RequestMapping(value="/loginerror", method= {RequestMethod.GET, RequestMethod.POST})
//    public String loginerror(@RequestParam("login_error")String loginError){
//        return "/members/loginerror";
//    }
//}
