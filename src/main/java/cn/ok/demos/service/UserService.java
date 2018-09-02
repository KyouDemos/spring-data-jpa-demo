package cn.ok.demos.service;

import cn.ok.demos.entity.User;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    public User getUser(int i) {
        User user = new User();
        user.setUserName("User" + i);
        user.setAge(18 + i);
        user.setBirthDay(new Date());
        user.setPhone(13691463890L + i);
        return user;
    }
}
