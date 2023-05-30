package com.spring.mvc.chap04.entity;
import lombok.*;

@Setter @Getter @ToString
@NoArgsConstructor @AllArgsConstructor      // 모든 멤버변수를 다 요구하는 생성자
public class Score {                        // 텍스트 파일 -> 테이블 형식으로 저장할 수 있다.

    private String name;
    private int korScore;
    private int engScore;
    private int mathScore;

    private int studentNumber;
    private int total;
    private double average;

}