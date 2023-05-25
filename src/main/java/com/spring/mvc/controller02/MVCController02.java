package com.spring.mvc.controller02;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/chap02")
public class MVCController02 {

    // .jsp로 자바 변수로 보내려면 Model을 선언해야 함.
    @RequestMapping("hobbies")
    public String hobbies(Model model) {
        String name = "룰루";

        List<String> hobbies = List.of("밥먹기", "낮잠자기", "쥐잡기");

        model.addAttribute("n", name);
        model.addAttribute("hList", hobbies);

        return "/chap02/hobbies";
    }

    // ModelAndView 객체를 사용해 뷰(view) 화면 구성하기
    // /chap02/hobbies2 : GET
    // 리턴자료형 : ModelAndView 객체
    @GetMapping("/hobbies2")
    public ModelAndView hobbies2() {
        //.jsp파일(view단)으로 보내고 싶은 자료 설정
        String name = "참참이";
        List<String> hList = List.of("전깃줄에서 꾸벅꾸벅 졸기", "쌀 주워먹기", "짹짹 소리 내기");

        // 목적지 뷰 이름 적기(포워딩 방식)
        String viewName = "chap02/hobbies";

        // ModelAndView 객체 생성 및 세팅하기
        ModelAndView mv = new ModelAndView();
        mv.setViewName(viewName);
        mv.addObject("n", name);
        mv.addObject("hList", hList);

        return mv;
    }


}
