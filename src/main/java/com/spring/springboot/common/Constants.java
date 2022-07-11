package com.spring.springboot.common;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Constants {

    private static final String[] bg = { "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" };
    public static final Set<String> BLOOD_GROUPS = new TreeSet<String>() {
        {
            addAll(Arrays.asList(bg));
        }
    };

}
