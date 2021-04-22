package com.bg.bgmanagement;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.bg.module_demo.DemoBean;
import com.bg.module_demo.DemoDao;

/**
 * created by dr_chene on 2021/4/22
 * desc room数据库
 */
@Database(entities = {DemoBean.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    abstract DemoDao getDemoDao();

    private static final String DATA_BASE_NAME = "bgmanagement.db";

    static AppDataBase buildDataBase(Context context) {
        return Room.databaseBuilder(context, AppDataBase.class, DATA_BASE_NAME).build();
    }
}
