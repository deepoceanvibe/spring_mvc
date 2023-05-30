package com.spring.mvc.chap04.controller;

import com.spring.mvc.chap04.entity.Score;
import com.spring.mvc.chap04.repository.ScoreRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/*
    학생의 성적정보를 조회, 등록, 삭제할 수 있는 시스템을 만들어 보자.

    1. 성적조회 + 등록폼 (GET 방식, DB변경X)
    2. 등록 (POST 방식, DB변경O)
    3. 삭제 (POST 방식, DB변경O)
    4. 상세조회 (GET 방식, DB변경X)
 */

@Controller
@RequestMapping("score")
// @AllArgsConstructor 모든 필드를 초기화하는 생성자
@RequiredArgsConstructor    // final 필드만 초기화하는 생성자
public class ScoreController {

    // repository를 선언해야, repository에서 데이터를 가져와서, 요청 양식에 맞춰 화면에 전달할 수 있음.
    // private 이라 생성자를 통해서만 데이터를 전달할 수 있고, final을 쓴 이유는 DB교체가 안되게 안정적으로 하려고
    // 자동으로 밑에 있는 자료형 ScoreRepository 정보를 -> ScoreController 안의 repository 변수 안에 '주입'됨
    // 생성자가 하나인 경우에는 Autowired 어노테이션을 굳이 안써도 자동으로 달아줌
    @Autowired
    private final ScoreRepository repository;


    // 1. 등록폼 + 조회
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        System.out.println("/score/list : GET방식");

        // repository 객체 내부의 전체 글 조회기능을 이용해 자료를 받아서 scoreList 변수에 저장하기
        List<Score> scoreList = repository.findAll();
        // 해당 성적 전체를 실어서 화면 단으로 보낼 수 있게 적재하기
        model.addAttribute("scoreList", scoreList);
        return "chap04/score-list";
    }

    // 2. 등록
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(Score score) {
        System.out.println("/score/register : POST방식");

        repository.save(score);
        return "redirect:/score/list";
    }

    // 3. 삭제
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String remove(int studentNumber) {
        System.out.println("/score/remove : POST방식");

        repository.deleteByStudentNumber(studentNumber);

        return "";
    }

    // 4. 상세조회
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String detail(Model model, int studentNumber) {
        System.out.println("/score/detail : GET방식");

        Score score = repository.findByStudentNumber(studentNumber);
        model.addAttribute("Score", score); // 학생 정보 view에 넘겨주기
        return "";
    }
}
