package com.spring.mvc.controller03;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/chap03")
public class MVCController03 {

    // 폼으로 넘겨주는 메서드
    @RequestMapping("/foodform")
    public String foodform() {
        return "chap03/foodform";
    }

    // 폼에서 날려준 데이터를 view단으로 넘겨주는 메서드
    @RequestMapping("/orderresult")
    public ModelAndView orderresult(String name, int tableNum, String orderMenu) {

        // view 객체 생성
        ModelAndView mv = new ModelAndView();

        // 데이터 적재
        mv.addObject("name", name);
        mv.addObject("tableNum", tableNum);
        mv.addObject("orderMenu", orderMenu);

        // 결과 view파일 지정
        mv.setViewName("chap03/orderresult");
        return mv;
    }

    // 리다이렉트
    @RequestMapping("/naver")
    public String naver() {
        return "redirect:https://www.naver.com";
    }

    @RequestMapping("/goFoodform")
    public String goFoodForm(Model model) {
        model.addAttribute("title", "음식 주문 키오스크");
        return "redirect:/foodform"; // foodform으로 포워딩하지 않고, 'http 주소/목적메서드'로 리다이렉트 하는 방법
        // return "/chap03/foodform"; // foodform.jsp '파일'로 적재 데이터도 보내는 포워딩 방식
    }

    // submit 방식으로 리다이렉트 하기
    @RequestMapping("searchform")
    public String searchForm() {
        return "/chap03/searchform";
    }

    // 네이버 쿼리를 받아서 리다이렉션 해주기
    @RequestMapping("research")
    public String reSearch(String query) {
        String resultPage = "redirect:https://search.naver.com/search.naver?query=" + query;
        return resultPage;
    }

}
