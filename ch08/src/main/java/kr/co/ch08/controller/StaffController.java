package kr.co.ch08.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class StaffController {

    @GetMapping(value = {"/staff", "staff/index"})
    public String index() {
        return "/staff/index";
    }
    
}
