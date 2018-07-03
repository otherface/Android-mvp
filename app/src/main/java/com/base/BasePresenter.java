package com.base;

/**
 * 业务逻辑处理基类
 * @author jianghua 2018 07/02
 */

public abstract class BasePresenter<M, T> {
    protected M mModel;
    protected T mView;
    //初始化参数
    public void setViewAndModel(T v, M m) {
        this.mView = v;
        this.mModel = m;
    }

    /**
     * 接触绑定操作
     */
    public void unBind(){
        if(null != mModel){
            mModel = null;
        }

        if(null != mView){
            mView = null;
        }
    }
}
