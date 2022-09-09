package com.test.TestController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.test.dao.CourseDaoImpl;
import com.test.repo.CourseRepo;

@SpringBootTest
@AutoConfigureMockMvc
public class courseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CourseRepo repo;
    @MockBean
    CourseDaoImpl dao;

    @Test
    public void testdisplayView() {
        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())// 200
                .andExpect(view().name("index"))
                .andExpect(model().attributeExists("list"));
    }
}
