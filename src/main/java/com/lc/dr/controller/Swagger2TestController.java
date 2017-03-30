package com.lc.dr.controller;

import com.lc.dr.annotations.MethodApi;
import com.lc.dr.mapper.UsersMapper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Desc:
 * Author:   licheng
 * Datetime: 2016-11-21 15:56
 */
@RestController
@RequestMapping(value = "swagger2")
public class Swagger2TestController {

    @Resource
    UsersMapper usersMapper;

    @ApiOperation(value = "新增用户", notes = "新增用户")
    @ApiImplicitParam(name = "desc", value = "用户描述", required = true, dataType = "String")
    @RequestMapping(value = "insertUser", method = RequestMethod.POST)
    @MethodApi
    public Boolean insertUser(@RequestBody String desc){

        return usersMapper.insertTest(desc)==1;
    }
}
