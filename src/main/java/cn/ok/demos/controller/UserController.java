package cn.ok.demos.controller;

import cn.ok.demos.entity.User;
import cn.ok.demos.repository.UserRepository;
import cn.ok.demos.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("getUsers")
    public String getAllUsers() {
        List<User> users = userRepository.findAll();
        log.debug("users: {}", users);
        return users.toString();
    }

    @GetMapping("addUsers/{cnt}")
    public String addUsers(@PathVariable("cnt") int cnt) {

        for (int i = 0; i < cnt; i++) {
            userRepository.save(userService.getUser(i));
        }
        log.debug("{} user added.", cnt);
        return cnt + " users added";
    }

    @GetMapping("getOneUser")
    public String getOneUser() {
        User user = userRepository.getOne(1);
        return user.toString();
    }


}

