package com.alkasima.getrequest.springgetrequest.service;

import com.alkasima.getrequest.springgetrequest.api.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private List<User> userList;

    public UserService() {
        userList = new ArrayList<>();

        User user1 = new User(1, "Kasim", 24, "alkasima@gmail.com");

        User user2 = new User(2, "Umaimah", 24, "umaimah@gmail.com");

        userList.addAll(Arrays.asList(user1));
    }

    public Optional<User> getUser(Integer id) {
        Optional optional = Optional.empty();
        for (User user: userList) {
            if(id == user.getId()) {
                optional = Optional.of(user);
                return optional;
            }
        }

        return optional;
    }
}
