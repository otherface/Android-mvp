package com.constrac;

import com.base.BaseModel;
import com.base.BasePresenter;
import com.base.BaseView;

/**
 * demo业务管理
 * @author jianghua 2018 07/02
 */

public interface DemoContract {
    interface DemoView extends BaseView {
        void refreshing();
    }

    interface DemoModel extends BaseModel {
        void setUserName(String name);
        void setUserSex(int sex);
    }

    abstract class Presenter extends BasePresenter<DemoModel, DemoView> {
        public abstract void login(String username, String password, String passcode);
    }
}
