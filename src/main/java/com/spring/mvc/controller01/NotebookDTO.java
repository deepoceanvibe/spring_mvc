package com.spring.mvc.controller01;
import lombok.Data;


// LOMBOK 사용법
// @Data 자동으로 getter, setter 생성자 등을 만들어줌
@Data
public class NotebookDTO {

    /* 커맨드 객체로 컨트롤러 파라미터 처리하는 방법
       반드시 세터와 기본생성자가 있어야 함
     */
    private String modelName;
    private int price;
    private int ssd;
    private int ram;




}
