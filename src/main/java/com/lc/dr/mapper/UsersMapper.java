package com.lc.dr.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Desc:
 * Author:   licheng
 * Datetime: 2016-11-21 11:35
 */
@Mapper
public interface UsersMapper {

    @Insert("insert into users(description) values(#{desc})")
    int insertTest(@Param("desc") String desc);
}
