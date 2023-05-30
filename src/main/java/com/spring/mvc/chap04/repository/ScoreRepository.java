package com.spring.mvc.chap04.repository;


import com.spring.mvc.chap04.entity.Score;

import java.util.List;

/*
    역할 명세(추상화)
    1. 전체 성적 조회
    2. 개별 성적 조회
    3. 성적 삭제
    4. 성적 등록

 */
public interface ScoreRepository {
    
    // 1. 전체 성적은 어떻게 받아올 것인가?
    // 1. entity에 score라는 정보 먼저 정의하고
    // 2. score 객체에 담아와서 처리하자.
    public List<Score> findAll();

    // 2. 성적 정보 등록
    // 등록 성공했는지, 실패했는지 리턴 (boolean)
    boolean save(Score score);  // 입력할 테이블 정보를 넘겨줘야 함 ('스코어'에 저장했는가?)

    // 3. 성적 정보 한 개 삭제
    boolean deleteByStudentNumber(int studentNumber);

    // 4. 성적 개별 조회
    Score findByStudentNumber(int studentNumber);

    
}
