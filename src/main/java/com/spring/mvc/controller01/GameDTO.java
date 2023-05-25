package com.spring.mvc.controller01;

import lombok.*;

@Getter @Setter
@ToString @NoArgsConstructor
public class GameDTO {
    private String gameName;
    private int price;
    private int sales;
}
