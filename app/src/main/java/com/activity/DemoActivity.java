package com.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.aaron.mvp.R;
import com.constrac.DemoContract;
import com.model.DemoModel;
import com.kincs.DemoBaseActivity;
import com.presenter.DemoPVPresenter;

/**
 * @author jianghua 2018 07/02
 */

public class DemoActivity extends DemoBaseActivity<DemoPVPresenter,DemoModel> implements DemoContract.DemoView {

    TextView demoTv;
    Button demoBtn;

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public int initLayoutID() {
        return R.layout.activity_demo_layout;
    }


    @Override
    public void handleOnCreated(Bundle savedInstanceState) {
        demoTv = findViewById(R.id.demo_tv);
        demoBtn = findViewById(R.id.demo_btn);
        demoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.login("jiangHua","123456","100");
            }
        });
    }
    @Override
    public void refreshing() {
        demoTv.setText(new StringBuilder().append(mModel.getUserName()).append(mModel.getUserSex()).toString());
    }
}
