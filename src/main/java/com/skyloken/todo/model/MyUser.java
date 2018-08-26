package com.skyloken.todo.model;

import java.io.Serializable;

public class MyUser implements Serializable {
    private final String name;

    public MyUser(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
