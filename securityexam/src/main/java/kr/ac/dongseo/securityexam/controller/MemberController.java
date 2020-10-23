package kr.ac.dongseo.securityexam.controller;

import java.security.Principal;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.dongseo.securityexam.dto.Member;
import kr.ac.dongseo.securityexam.service.security.MemberService;

@Controller
@RequestMapping(path = "/members")
public class MemberController {
    // 스프링 컨테이너가 생성자를 통해 자동으로 주입한다.
    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    public MemberController(MemberService memberService, PasswordEncoder passwordEncoder){
        this.memberService = memberService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/loginform")
    public String loginform(){
        return "members/loginform";
    }

    @RequestMapping(value="/loginerror", method= {RequestMethod.GET, RequestMethod.POST})
    public String loginerror(@RequestParam("login_error")String loginError){
        return "members/loginerror";
    }

    @GetMapping("/joinform")
    public String joinform(){
        return "members/joinform";
    }

    // 사용자가 입력한 name, email, password가 member에 저장된다.
    @PostMapping("/join")
    public String join(@ModelAttribute Member member){
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        memberService.addMember(member, false);
        return "redirect:/members/welcome";
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "members/welcome";
    }

    @GetMapping("/memberinfo")
    public String memberInfo(Principal principal, ModelMap modelMap){
        String loginId = principal.getName();
        Member member = memberService.getMemberByEmail(loginId);
        modelMap.addAttribute("member", member);

        return "members/memberinfo";
    }
}