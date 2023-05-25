package com.spring.mvc.controller;

import com.spring.mvc.controller01.GameDTO;
import org.junit.jupiter.api.Test;

public class GameDTOTest {

    @Test
    public void GameDTOTest() {
        GameDTO game = new GameDTO();
        game.getGameName();
        game.getPrice();
        game.getSales();
        game.setGameName("ZELDA");
        System.out.println("setter 확인 : " + game);
    }
}
