package com.smartwasser.yunzhishui.alarm;

import android.widget.ListView;

import com.smartwasser.yunzhishui.Activity.BaseActivity;
import com.smartwasser.yunzhishui.R;

/**
 * Created by 15810 on 2019/2/20.
 */

public class AlarmActivity extends BaseActivity {
    private ListView mListView;
    @Override
    protected int initContentView() {
        return R.layout.avtivity_alarm;
    }

    @Override
    protected void initView() {
        mListView   =    findViewById(R.id.wraing_list);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
}
