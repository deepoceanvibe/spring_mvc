package com.spring.mvc.controller01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// 해당 어노테이션이 있어야, 스프링 코어가 관리하는 컨트롤러가 됨.
@Controller
public class MVCController01 {

    // 특정 주소로 접속했을 때 처리할 로직을 작성한다.
    // localhost:8080 이 기본주소이고, 뒤에 /hello를 붙여 접속시 실행
    @RequestMapping("/hello")
    public String hello() {
        System.out.println("/hello 접속 감지!!!");

        // 어떤 .jsp 파일과 연동할지 return 구문에 문자열로 파일 이르믈 적어줌
        // prefix 였던 /WEB_INF/view와 suffix였던 .jsp를 앞 뒤로 붙여서
        // 최종적으로 열리는 파일은 /WEB-INF/view/hello.jsp
        return "hello";
        }

        @GetMapping("/getreq")
        public String getReq() {
            System.out.println("get방식 요청을 감지했습니다!");
            return "reqview";
        }
        @PostMapping("/postreq")
        public String getPost() {
            System.out.println("post방식 요청을 감지했습니다!");
            return "reqview";
        }
    }
