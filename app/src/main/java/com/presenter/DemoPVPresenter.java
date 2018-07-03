package com.presenter;

import com.constrac.DemoContract;

/**
 * demo业务处理,网络请求等
 * @author jianghua 2018 07/02
 */

public class DemoPVPresenter extends DemoContract.Presenter{

    @Override
    public void login(String username, String password, String passcode) {
        mModel.setUserName(username);
        mModel.setUserSex(1);
        mView.refreshing();
    }
}
