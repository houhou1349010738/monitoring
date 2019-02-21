package com.smartwasser.yunzhishui;
import android.app.Application;
import android.content.SharedPreferences;


/**
 * Created by xiongmc on 2015/12/22.
 */
public class App extends Application {

    /**
     * 全局Application，方便调用
     */
    public static App application;
    public SharedPreferences SP;
    public SharedPreferences.Editor EDIT;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        SP = getSharedPreferences("config", MODE_PRIVATE);
        EDIT = SP.edit();

    }
}
