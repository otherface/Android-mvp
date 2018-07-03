package com.bean;

import java.io.Serializable;

/**
 * @author jianghua 2018 07/02
 */

public class User implements Serializable {
    private String name;
    private int sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
