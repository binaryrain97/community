package com.example.community.controller;

import com.example.community.model.entity.Member;
import com.example.community.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;
    @GetMapping("/signup")
    public String getSignup(Member member) {return "signup_form";}

    @PostMapping("/signup")
    public String postSignup(@RequestParam String userId,
                             @RequestParam String password) {
        memberService.create(userId, password);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "login_form";
    }
}
