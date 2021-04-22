package com.bg.module_demo;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * created by dr_chene on 2021/4/22
 * desc
 */
@Entity(tableName = "demos")
public class DemoBean {
    public String name;
    @PrimaryKey
    private int num;
}
