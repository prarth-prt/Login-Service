package com.prarthana.auctionapp.LoginService;

import com.prarthana.auctionapp.LoginService.model.Userdetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@ConfigurationProperties
@RestController

public class UserController {
    @Value("${application.message}")
    String message;

    @Value("${application.appname}")
    String appname;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    String home() {
        return "Hello World....- " + message + " " + appname;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public Userdetails create(@RequestBody Userdetails user) {
        return userRepository.save(user);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/{username}")
    public Userdetails get(@PathVariable String username) {
        return userRepository.findOne(username);
    }

}
