package com.test.TestService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
// import static org.mockito.Mockito.when;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.dao.CourseDaoImpl;
import com.test.dto.CourseRes;
import com.test.repo.CourseRepo;

@SpringBootTest
public class courseServiceTest {
    @Mock
    CourseRepo repo;

    @InjectMocks
    CourseDaoImpl courseDao;

    @Test
    public void courseInsertTest() {
        CourseRes cou1 = new CourseRes();
        cou1.setCid(1);
        cou1.setName("php");
        courseDao.insertCourse(cou1);
        verify(repo, times(1)).save(cou1);
    }

    @Test
    public void CourseShowAllTest() {
        List<CourseRes> list = new ArrayList<CourseRes>();
        CourseRes cou1 = CourseRes.builder().cid(1).name("php").build();
        CourseRes cou2 = CourseRes.builder().cid(2).name("java").build();
        CourseRes cou3 = CourseRes.builder().cid(3).name("linux").build();
        list.add(cou1);
        list.add(cou2);
        list.add(cou3);
        when(repo.findAll()).thenReturn(list);
        List<CourseRes> coursList = courseDao.showCouse();

        assertEquals(3, coursList.size());
        verify(repo, times(1)).findAll();// အလုပ်လုပ်လား စစ်တာ
    }

    @Test
    public void CourseMaxIdTest() {
        CourseRes cou1 = new CourseRes();
        cou1.setCid(1);
        cou1.setName("php");
        when(repo.courseMaxid()).thenReturn(1);
        assertEquals(1, courseDao.couresMaxid());
        verify(repo, times(1)).courseMaxid();
    }

    @Test
    public void GetcourseofoneTest() {
        List<CourseRes> list = new ArrayList<CourseRes>();
        CourseRes cou1 = new CourseRes();
        cou1.setCid(1);
        cou1.setName("php");
        CourseRes cou2 = new CourseRes();
        cou1.setCid(2);
        cou1.setName("java");
        CourseRes cou3 = new CourseRes();
        cou1.setCid(3);
        cou1.setName("linux");
        list.add(cou1);
        list.add(cou2);
        list.add(cou3);
        when(repo.getcourseofspecifci(1)).thenReturn(list);
        List<CourseRes> coursList = courseDao.getcourseofone(1);
        assertEquals(3, coursList.size());
        verify(repo, times(1)).getcourseofspecifci(1);// အလုပ်လုပ်လား စစ်တာ
    }
}