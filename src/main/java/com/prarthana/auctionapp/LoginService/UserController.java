package com.prarthana.auctionapp.LoginService;

import com.prarthana.auctionapp.LoginService.model.Userdetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



@RestController
@RequestMapping("/login")
public class UserController {

    @Autowired
    private UserRepository userRepository;

//    @RequestMapping("/")
//    String home() {
//        return "Hello World....- " + message + " " + appname;
//    }

    @RequestMapping(value = "/auth", produces = {"application/json"}, method = RequestMethod.POST)
   public Map<String, Object> auth(@RequestBody Userdetails user) {
//    public String auth(@RequestBody Userdetails user) {

        String userName = user.getUsername();
        String password = user.getPassword();
        List<Userdetails> users = userRepository.findAll();

//to search result set from  mongo DB based on username
//        String users = userRepository.findByUsername(userName).toString();

//        if (users.isEmpty()) {
//            String name = users;
//            return name;
//        } else {
//            return "Login Success";
//        }
//    }
//}

        String userId = "";
        for (Userdetails user1 : users) {
            if (user1.getUsername().equals(userName) && user1.getPassword().equals(password)) {
                userId = user1.getId();
            }
        }
        Map<String, Object> dataMap = new HashMap<String, Object>();
        if (userId.isEmpty()) {
            dataMap.put("message", "login not found!!");
            dataMap.put("status", "500");
            System.out.print("Login Failed");
        } else {
            dataMap.put("message", "login found!!");
            dataMap.put("status", "200");
            System.out.print("Login Success");
        }
        dataMap.put("userId", userId);
        return dataMap;
    }
}








