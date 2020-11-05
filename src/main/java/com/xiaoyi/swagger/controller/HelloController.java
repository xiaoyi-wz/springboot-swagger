package com.xiaoyi.swagger.controller;

import com.xiaoyi.swagger.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//Operation(接口api

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    @PostMapping("/user")
    public User user(){
        return new User();
    }
    //Operation接口，不是放在类上 是方法
    @ApiOperation("hello控制类")
    @GetMapping("/hello2")
    public String hello2(@ApiParam("用户名")String username){
        return "hello"+username;
    }
}
