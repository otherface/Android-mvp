package com.model;

import com.constrac.DemoContract;

/**
 * 页面需要的数据模型
 * @author jianghua 2018 07/02
 */

public class DemoModel implements DemoContract.DemoModel {

    private String userName;
    private int userSex;

    @Override
    public void setUserName(String name) {
        this.userName = name;
    }

    @Override
    public void setUserSex(int sex) {
        this.userSex = sex;
    }

    public String getUserName() {
        return userName;
    }

    public int getUserSex() {
        return userSex;
    }
}
