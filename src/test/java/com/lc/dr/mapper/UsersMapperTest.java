package com.lc.dr.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Desc:
 * Author:   licheng
 * Datetime: 2016-11-21 11:43
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersMapperTest {

    @Resource
    UsersMapper usersMapper;

    @Test
    public void testMapper(){

//        System.out.println(usersMapper.insertTest("lcdr"));
    }
}
