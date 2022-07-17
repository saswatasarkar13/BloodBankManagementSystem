package com.spring.springboot.helpers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.springboot.models.User;

@Component
public class Achievement {

    public List<String> getAchievements(User user) {
        List<String> list = new ArrayList<>();

        if (user.isActivelyDonating()) {
            list.add("active-donor");
        }

        if (user.getDonations().size() > 1) {
            list.add("pro-donate");
        }

        return list;
    }
}