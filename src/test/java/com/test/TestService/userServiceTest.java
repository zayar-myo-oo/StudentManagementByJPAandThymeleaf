package com.test.TestService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.dao.UserDaoImpl;
import com.test.dto.UserRes;
import com.test.repo.UserRepo;

@SpringBootTest
public class userServiceTest {
    @Mock
    UserRepo repo;
    @InjectMocks
    UserDaoImpl dao;

    @Test
    public void InsertUserTest() {
        UserRes res = UserRes.builder()
                .id(1).name("zayar").email("ggg@gmai.com")
                .password("1234").role("admin").build();
        // mock နဲ့ထည့်ကြည့်မယ်
        dao.insertUser(res);
        verify(repo, times(1)).save(res);
    }

    @Test
    public void updateUserTest() {
        UserRes res = UserRes.builder()
                .id(1).name("zayar").email("ggg@gmai.com")
                .password("1234").role("admin").build();
        dao.updateUser(res);
        verify(repo, times(1)).save(res);
    }

    @Test
    public void deleteUserTest() {
        dao.deleteUser(1);
        verify(repo, times(1)).deleteById(1);
    }

    @Test
    public void showUserTest() {
        List<UserRes> list = new ArrayList<UserRes>();
        UserRes res1 = UserRes.builder()
                .id(1).name("zayar").email("zayar@gmai.com")
                .password("1234").role("admin").build();
        UserRes res2 = UserRes.builder()
                .id(2).name("mgmg").email("mgmg@gmai.com")
                .password("1234").role("admin").build();
        UserRes res3 = UserRes.builder()
                .id(3).name("kyaw Kyaw").email("kyawgyi@gmai.com")
                .password("1234").role("admin").build();
        list.add(res1);
        list.add(res2);
        list.add(res3);
        when(repo.findAll()).thenReturn(list);
        List<UserRes> userList = dao.showUser();
        assertEquals(3, userList.size());
        verify(repo, times(1)).findAll();
    }

    @Test
    public void specificLogicTest() {
        List<UserRes> list = new ArrayList<UserRes>();
        UserRes res = UserRes.builder()
                .id(2).name("zayar").email("mgmg@gmai.com")
                .password("1234").role("admin").build();
        list.add(res);

        when(repo.findByNameAndId(res.getId(), res.getName())).thenReturn(list);
        assertEquals(list, repo.findByNameAndId(res.getId(), res.getName()));

        when(repo.findById(2)).thenReturn(list);
        assertEquals("zayar", repo.findById(2).get(0).getName());

        when(repo.findByname(res.getName())).thenReturn(list);
        assertEquals("zayar", repo.findById(2).get(0).getName());

        when(repo.findByidAndpassword(res.getId(), res.getPassword())).thenReturn(res);
        assertEquals(res, repo.findByidAndpassword(res.getId(), res.getPassword()));
        verify(repo, times(1)).findByidAndpassword(res.getId(), res.getPassword());

    }
}