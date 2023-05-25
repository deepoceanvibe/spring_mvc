package com.spring.mvc.controller;

import com.spring.mvc.controller01.NotebookDTO;
import org.junit.jupiter.api.Test;

public class NotebookDTOTest {

    @Test
    public void notebookDTOTest() {
        NotebookDTO notebook = new NotebookDTO();
        notebook.getRam();
        notebook.setModelName("MACBOOK PRO M2");
        System.out.println("setter 확인 : " + notebook);
    }
}
