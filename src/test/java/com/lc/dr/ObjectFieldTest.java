package com.lc.dr;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Date:   2017/2/28.
 * Author: licheng
 */
public class ObjectFieldTest {

    String fieldNames = "userId,userName";

    @Test
    public void testObjectFieldRemove() throws IllegalAccessException {

        User user1 = new User();
        user1.setUserId("lc");
        user1.setUserName("LC_DR");
        user1.setUserMobile("156345");

        User user2 = new User();
        user2.setUserId("lc2");
        user2.setUserName("LC_DR2");
        user2.setUserMobile("4584593845");

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);

        System.err.println(JSON.toJSONString(userList));

        List fieldNameList = Arrays.asList(fieldNames.split(","));
        userList.forEach(user -> {
            fieldNameList.forEach(fieldName -> {
                try {
                    FieldUtils.writeField(user, String.valueOf(fieldName), null, true);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            });
        });

        System.err.println(JSON.toJSONString(userList));
    }
}


class User{

    public String userId;

    public String userName;

    public String userMobile;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }
}
