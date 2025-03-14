package kr.co.ch04.controller;



import kr.co.ch04.dto.User2DTO;

import kr.co.ch04.service.User2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class User2Controller {


    private User2Service service;

    // 생성자 주입
    @Autowired
    public User2Controller(User2Service service) {
        this.service = service;
    }

    @RequestMapping(value = "/user2/list", method = RequestMethod.GET)
    public String list(Model model) {

        // 서비스 호출
        List<User2DTO> user2List = service.findAll();

        // 모델 참조 공유
        model.addAttribute("user2List",user2List);

        // 뷰 포워드
        return "/user2/list";


    }

    @GetMapping("/user2/register")
    public String register() {
        return "/user2/register";
    }

    @PostMapping("/user2/register")
    public String register(User2DTO dto) {
        System.out.println(dto);

        // 서비스 호출
        service.save(dto);

        // 리다이렉트 이동
        return "redirect:/user2/list";

    }

    public String modify(Model model, @RequestParam("uid") String uid) {

        // 서비스 호출
        User2DTO dto = service.findById(uid);

        // 모델 참조 공유
        model.addAttribute(dto);

        return "/user2/modify";
    }

    @PostMapping("/user2/modify")
    public String modify(User2DTO dto) {

        // 서비스 호출
        service.update(dto);

        // 리다이렉트
        return "redirect:/user2/list";

    }

}
