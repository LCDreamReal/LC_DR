package com.lc.dr.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.INTERNAL;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Desc:
 * Author:   licheng
 * Datetime: 2016-11-21 11:43
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class UsersMapperTest {

//    @Resource
//    UsersMapper usersMapper;

    @Test
    public void testMapper(){

//        System.out.println(usersMapper.insertTest("lcdr"));

        List<String> colorList = new ArrayList<>();
        colorList.add("RED");
        colorList.add("BLUE");
        colorList.add("GREEN");
        System.out.println(colorList.stream().filter(color -> color.contains("E")).count());

        List<String> lowerList = colorList.stream().map(String::toLowerCase).collect(Collectors.toList());
        lowerList.stream().forEach(System.out::println);

        Stream<List<Integer>> inputStreams = Stream.of(
                Arrays.asList(1),
                Arrays.asList(1,2),
                Arrays.asList(1,2,3)
        );
        Stream<Integer> outStream = inputStreams.flatMap((child) -> child.stream());
        outStream.forEach(System.out::println);
    }
}
