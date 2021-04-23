package com.bg.lib_base;

import android.app.Application;

import com.bg.lib_base.bean.User;

/**
 * created by dr_chene on 2021/4/22
 * desc application基类
 */
public class BaseApp extends Application {
    public static User user = null;
    public static int userType = 3;
}
