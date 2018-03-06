package com.sai.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    private static int userCount = 3;

    static {
        users.add(new User(1, "Sai", new Date()));
        users.add(new User(2, "Ramesh", new Date()));
        users.add(new User(3, "Mahesh", new Date()));

    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {

        if (user.getId() == null) {
            user.setId(++userCount);
        }

        users.add(user);
        return user;
    }

    public User findOne(int id) {

        User foundUser = null;

        for (User user: users
             ) {
            if(user.getId() == id) {
                foundUser = user;
                break;
            }
        }

        return foundUser;
    }
}
