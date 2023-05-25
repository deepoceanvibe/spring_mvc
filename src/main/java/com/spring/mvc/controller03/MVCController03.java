package com.spring.mvc.controller03;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/chap03")
public class MVCController03 {

    @RequestMapping("/foodform")
    public ModelAndView foodform() {
        System.out.println("음식을 주문하세요.");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("chap03/foodform");

        return mv;
    }
    @RequestMapping("/orderresult")
    public ModelAndView orderresult(HttpServletRequest request) {
        String name = request.getParameter("name");
        int tableNum = Integer.parseInt(request.getParameter("tableNum"));
        String orderMenu = request.getParameter("orderMenu");

        List<String> fList = List.of("사과", "딸기", "키위");
        String viewName = "chap03/orderresult";
        ModelAndView mv = new ModelAndView();
        mv.setViewName(viewName);
        mv.addObject("name", name);
        mv.addObject("tableNum", tableNum);
        mv.addObject("orderMenu", orderMenu);

        return mv;
    }





}
