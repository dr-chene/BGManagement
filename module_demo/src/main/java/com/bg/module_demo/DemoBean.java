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
    public long num;

    public DemoBean(String name, long num) {
        this.name = name;
        this.num = num;
    }

    @Override
    public String toString() {
        return "DemoBean{" +
                "name='" + name + '\'' +
                ", num=" + num +
                '}';
    }
}
