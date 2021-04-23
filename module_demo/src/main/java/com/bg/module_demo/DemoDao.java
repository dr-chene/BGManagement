package com.bg.module_demo;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

/**
 * created by dr_chene on 2021/4/22
 * desc
 */
@Dao
public interface DemoDao {

    //查询语句，返回值这样写是为了简单，别学
    @Query("SELECT * FROM demos")
    List<DemoBean> getDemos();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(DemoBean demo);
}
