package kr.co.ch04.controller;


import kr.co.ch04.dto.User3DTO;
import kr.co.ch04.service.User3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class User3Controller {

    private User3Service service;

    // 생성자 주입
    @Autowired
    public User3Controller(User3Service service) {
        this.service = service;
    }

    @RequestMapping(value = "/user3/list", method= RequestMethod.GET)
    public String list(Model model) {

        // 서비스 호출
        List<User3DTO> user3List = service.findAll();

        // 모델 참조 공유
        model.addAttribute("user3List", user3List);

        // 뷰 포워드
        return "/user3/list";


    }

    @GetMapping("/user3/register")
    public String register() {
        return "/user3/register";
    }

    @PostMapping("/user3/register")
    public String register(User3DTO dto) {
        System.out.println(dto);

        // 서비스 호출
        service.save(dto);

        // 리다이렉트 이동
        return "/redirect:/user3/list";
    }

    public String modify(Model model, @RequestParam("uid") String uid) {

        // 서비스 호출
        User3DTO dto = service.findById(uid);

        // 모델 참조 공유
        model.addAttribute(dto);

        return "/user3/modify";

    }

    @PostMapping("/user3/modify")
    public String modify(User3DTO dto) {

        // 서비스 호출
        service.update(dto);

        // 리다이렉트
        return "redirect:/user3/list";

    }



}
