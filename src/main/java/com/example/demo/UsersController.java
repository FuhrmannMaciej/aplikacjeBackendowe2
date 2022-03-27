package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UsersController {

    private Map<Integer, UserEntity> users = Map.of(1,new UserEntity("john", 21),
                                                    2,new UserEntity("tom", 18),
                                                    3,new UserEntity("paul", 42));


    @RequestMapping("/users")
    @ResponseBody
    public Object index() {
        return users;
    }
}