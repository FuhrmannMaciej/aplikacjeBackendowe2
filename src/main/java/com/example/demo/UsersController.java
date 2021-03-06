package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.TreeMap;

@Controller
public class UsersController {

    private TreeMap<Integer, UserEntity> users = new TreeMap<>(){{
                        put(1,new UserEntity("john", 21));
                        put(2,new UserEntity("tom", 18));
                        put(3,new UserEntity("paul", 42));
    }};


    @RequestMapping("/users")
    @ResponseBody
    public Object users() {
        return users.values();
    }

    @RequestMapping("/users/{id}/get")
    @ResponseBody
    public Object getUser(@PathVariable int id) {
        return users.get(id);
    }

    @RequestMapping("/users/{id}/remove")
    @ResponseBody
    public Object removeUser(@PathVariable int id) {
        return users.remove(id);
    }

    //http://localhost:8080/users/add?name=matt&age=35
    @RequestMapping("/users/add")
    @ResponseBody
    public Object addUser(@RequestParam String name, @RequestParam int age) {
        users.put(users.lastKey() + 1, new UserEntity(name, age));
        return users.get(users.lastKey());
    }
}