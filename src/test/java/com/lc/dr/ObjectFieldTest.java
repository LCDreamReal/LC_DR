package com.lc.dr;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Date:   2017/2/28.
 * Author: licheng
 */
public class ObjectFieldTest {

    String fieldNames = "userId,userName";

    @Test
    public void testObjectFieldRemove() throws IllegalAccessException {

//        List<String> list = Arrays.asList("a", "b", "c", "c", "d", "f", "a");
//        Stream.iterate(0, i -> i + 1).limit(list.size()).forEach(i -> {
//            System.out.println(String.valueOf(i) + list.get(i));
//        });

        Map<String, String> map = new HashMap<String, String>(){
            @Override
            public boolean containsKey(Object key) {
                return false;
            }
        };
        map.put("1", "1");
        System.out.println(map.containsKey("1"));

        User user1 = new User();
        user1.setUserId("lc");
        user1.setUserName("LC_DR");
        user1.setUserMobile("156345");
        System.out.println(Objects.hash(user1.getUserId(), user1.getUserName(), user1.getUserMobile()));
        user1.setUserMobile("156345 ");
        System.out.println(Objects.hash(user1.getUserId(), user1.getUserName(), user1.getUserMobile()));

//        User user2 = new User();
//        user2.setUserId("lc2");
//        user2.setUserName("LC_DR2");
//        user2.setUserMobile("4584593845");
//
//        List<User> userList = new ArrayList<>();
//        userList.add(user1);
//        userList.add(user2);
//
//        System.err.println(JSON.toJSONString(userList));
//
//        List fieldNameList = Arrays.asList(fieldNames.split(","));
//        userList.forEach(user -> {
//            fieldNameList.forEach(fieldName -> {
//                try {
//                    FieldUtils.writeField(user, String.valueOf(fieldName), null, true);
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//            });
//        });
//
//        System.err.println(JSON.toJSONString(userList));
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
