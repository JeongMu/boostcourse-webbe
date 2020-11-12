package kr.ac.dongseo.reservation.controller;

import kr.ac.dongseo.reservation.dto.security.Member;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import kr.ac.dongseo.reservation.service.security.MemberService;

@Controller
@RequestMapping(path = "/members")
public class MemberController {
	private final MemberService memberService;
	private final PasswordEncoder passwordEncoder;

	public MemberController(MemberService memberService, PasswordEncoder passwordEncoder) {
		this.memberService = memberService;
		this.passwordEncoder = passwordEncoder;
	}

	@GetMapping("/joinform")
	public String joinform() {
		return "members/joinform";
	}

	@PostMapping("/join")
	public String join(@ModelAttribute Member member) {
		member.setPassword(passwordEncoder.encode(member.getPassword()));
		memberService.addMember(member, false);
		return "redirect:/";
	}

	@GetMapping("/loginform")
	public String loginform() {
		return "members/loginform";
	}

	@RequestMapping(value="/loginerror", method= {RequestMethod.GET, RequestMethod.POST})
    public String loginerror(@RequestParam("login_error")String loginError){
        return "members/loginerror";
    }

}
