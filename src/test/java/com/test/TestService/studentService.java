package com.test.TestService;

import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.dao.StudentDaoImpl;
import com.test.dto.StudentRes;
import com.test.repo.StudentRepo;

@SpringBootTest
public class studentService {

        @Mock
        StudentRepo repo;
        @InjectMocks
        StudentDaoImpl dao;

        @Test
        public void insertStudentTest() {
                StudentRes res = StudentRes.builder().id(1)
                                .dob("2022-12-12").gender("male")
                                .education("ACE").name("zayar").phone("09268312901")
                                .build();
                dao.insertStudent(res);
                verify(repo, times(1)).save(res);
        }

        @Test
        public void updateStudentTest() {
                StudentRes res = StudentRes.builder().id(1)
                                .dob("2022-12-12").gender("male")
                                .education("ACE").name("zayar").phone("09268312901")
                                .build();
                dao.insertStudent(res);
                verify(repo, times(1)).save(res);
        }

        @Test
        public void deleteUserTest() {
                StudentRes res = StudentRes.builder().id(1)
                                .dob("2022-12-12").gender("male")
                                .education("ACE").name("zayar").phone("09268312901")
                                .build();
                dao.deleteStudent(res);
                verify(repo, times(1)).delete(res);
        }

        @Test
        public void studentMaxIDTest() {
                when(repo.MaxStuID()).thenReturn(1);
                assertEquals(1, repo.MaxStuID());
                verify(repo, times(1)).MaxStuID();
        }

        @Test
        public void showStudentTest() {
                List<StudentRes> list = new ArrayList<StudentRes>();
                StudentRes res1 = StudentRes.builder().id(1)
                                .name("zayar").dob("2022-12-22").education("ACE")
                                .phone("09268312901").course("java,php")
                                .build();
                StudentRes res2 = StudentRes.builder().id(2)
                                .dob("2022-12-22")
                                .education("ACE").name("hlahla").phone("09268312901").course("javascript,php")
                                .build();
                StudentRes res3 = StudentRes.builder().id(3)
                                .dob("2022-12-24")
                                .education("ACE").name("mgmg").phone("09268312901").course(".net,linux")
                                .build();
                list.add(res1);
                list.add(res2);
                list.add(res3);
                when(repo.findall()).thenReturn(list);
                List<StudentRes> stu = dao.showStudent();
                assertEquals(3, stu.size());
                verify(repo, times(1)).findall();
        }

        @Test
        public void specificLogicTest() {
                List<StudentRes> list = new ArrayList<StudentRes>();
                StudentRes res1 = StudentRes.builder().id(1)
                                .name("zayar").dob("2022-12-22").education("ACE")
                                .phone("09268312901").course("java,php")
                                .build();
                list.add(res1);

                when(repo.findByid(res1.getId())).thenReturn(list);
                assertEquals(1, repo.findByid(res1.getId()).get(0).getId());

                when(repo.specific(res1.getId(), res1.getName(), res1.getCourse())).thenReturn(list);
                assertEquals(list, repo.findByid(res1.getId()));

                when(repo.specificwithall(res1.getId(), res1.getName(), res1.getCourse())).thenReturn(list);
                assertEquals(list, repo.findByid(res1.getId()));

                when(repo.getone(res1.getId())).thenReturn(res1);
                assertEquals(res1, repo.findByid(res1.getId()).get(0));

        }

}
