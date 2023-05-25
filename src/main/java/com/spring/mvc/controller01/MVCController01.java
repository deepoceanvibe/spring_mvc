package com.spring.mvc.controller01;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// 해당 어노테이션이 있어야, 스프링 코어가 관리하는 컨트롤러가 됨.
@Controller
@RequestMapping("/chap01")
public class MVCController01 {

        // @GetMapping("/getreq")
        @RequestMapping(value = "/getreq", method = {RequestMethod.GET}) //,RequestMethod.POST})
            public String getReq() {
            System.out.println("get방식 요청을 감지했습니다!");
            return "reqview";
        }
        @PostMapping("/postreq")
        public String getPost() {
            System.out.println("post방식 요청을 감지했습니다!");
            return "reqview";
        }


        /*
        요청 파라미터 읽어오기(Query String = GET 방식, RequestBody = POST 방식)
        1. HttpServletRequest 사용하기 (원시적인 JSP 에서 쓰는 방법)
        /person?name=kim&age=30
         */

    // http 데이터(Query String으로 들어온) -> java 데이터 변환하는 과정
    // http 전송방식에서는 모든 파라미터가 문자형으로 받음
    @RequestMapping("/person")
    public String person(HttpServletRequest request) {
        String name = request.getParameter( "name");
        String age = request.getParameter( "age");

        System.out.println("name 파라미터 전송값 : " + name);
        System.out.println("age 파라미터 전송값 : " + age);
        return "";
    }

    /*
    @RequestParam 사용하기
    /major?stu=kim&major=computerscience&gpa=3.4
    메서드 선언 부에 파라미터와 자료형을 입력하고, 왼쪽에 @RequestParam("가져올 변수명") 입력
     */
    @RequestMapping("/major")
    public String major(String stu,
                        @RequestParam(defaultValue = "0.0") double gpa,
                        @RequestParam("major") String 전공) {
        System.out.println("stu 파라미터에 저장된 값 : " + stu);
        System.out.println("gpa 파라미터에 저장된 값 : " + gpa);
        System.out.println("gpa가 만점에서 몇 점 모자란지 : " + (4.5 - gpa));
        System.out.println("major 라는 명칭으로 전달된 '전공' 변수 : " + 전공);

        return "";
    }

    /*
        3. 커맨드 객체 이용하기
        연관된 자료를 한 번에 처리해야 하는 경우 외부에 class를 하나 만들고
        그 클래스를 파라미터로 주면 외부 클래스의 내부 멤버변수명이 전부 매핑되어 주입됨.
     */

    // NotebookDTO의 멤버변수(modelName, price, ram, ssd 명칭)으로 들어옴

    @RequestMapping("notebook")
    public String notebook(NotebookDTO notebook) {
        System.out.println("파라미터로 전달받은 NotebookDTO 내부 : " + notebook);
        return "";

    }

    @RequestMapping("game")
    public String game(GameDTO game) {
        System.out.println("Game 정보 : " + game);
        return "";
    }

    /*
        4. URL에 경로로 붙어있는 데이터 -> 경로 변수
        /board/103 -> bNo 변수 안에 103을 대입하겠다
        -> 게시판의 103번 글을 읽고 싶음
     */
    @RequestMapping("/board/{bNo}")
    public String board(@PathVariable int bNo) {
        System.out.println("경로로 받아온 bNo의 값 : " + bNo);
        return "";
    }

    @RequestMapping("/member/{mName}/{mNo}")
    public String member(@PathVariable String mName, @PathVariable long mNo) {
        System.out.println("http에서 받아온 멤버이름 : " + mName);
        System.out.println("http에서 받아온 멤버번호 : " + mNo);
        return "";
    }

    // 데이터를 보낼 때는 당연히 폼이라는 양식을 제공하고, (URL에 파라미터를 붙여서 보내는 대신)
    // 거기에 대해서 적절한 처리를 하는
    // 처리 메서드를 만들게 된다.
    @RequestMapping("/catform")
    public String catForm() {
        System.out.println("고양이를 등록할 수 있는 폼으로 연결해드립니다.");

        // /WEB-INF/views/chap01/catform.jsp
        return "/chap01/catform";
    }

    // catform에서 보낸 데이터를 처리해주는 페이지 생성
    @PostMapping ("/cat")
    public String cat(String name, int age, String kind) {
        System.out.println("등록할 고양이 이름 : " + name);
        System.out.println("등록할 고양이 나이 : " + age);
        System.out.println("등록할 고양이 품종 : " + kind);

        return "/chap01/catreg";
    }

    @RequestMapping ("/loginform")
    public String loginform() {
        System.out.println("로그인 화면으로 넘어갑니다.");
        return "/chap01/loginform";
    }

    @RequestMapping (value = "/login", method = RequestMethod.POST)
    public String login(String id, String pw) {
        System.out.println("아이디 : " + id);
        System.out.println("비밀번호 : " + pw);
        return "/chap01/loginreg";
    }






    }
