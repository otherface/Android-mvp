package com.kincs;

import android.app.Activity;
import android.view.Window;
import android.os.Bundle;

import com.base.BaseModel;
import com.base.BasePresenter;
import com.base.BaseView;
import com.utils.MVPUtil;

/**
 * 简单的基类activity
 *
 * @author jianghua 2018 07/02
 */
public abstract class DemoBaseActivity<T extends BasePresenter, E extends BaseModel> extends Activity {
    //继承类返回自己的xml文件名字，用于购建页面
    public abstract int initLayoutID();

    public abstract void handleOnCreated(Bundle savedInstanceState);

    //业务逻辑处理
    protected T mPresenter;
    //业务model
    protected E mModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        int layoutResID = initLayoutID();
        setContentView(layoutResID);

        handleOnCreated(savedInstanceState);

        mPresenter = MVPUtil.getT(this, 0);
        mModel = MVPUtil.getT(this, 1);
        if (this instanceof BaseView) {
            mPresenter.setViewAndModel(this, mModel);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //解除绑定
        if (null != mPresenter) {
            mPresenter.unBind();
            mPresenter = null;
        }
    }
}

