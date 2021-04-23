package com.bg.lib_base.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * created by dr_chene on 2021/4/23
 * desc user类，包含普通用户（n），管理员（a），超级管理员（a）
 */
public class User {
    public static final int NULL = 3;
    public static final int NORMAL = 2;
    public static final int ADMIN = 1;
    public static final int SUPER_ADMIN = 0;

    public int id;
    @SerializedName(value = "userId", alternate = "adminId")
    public String cate;
    @SerializedName(value = "userName", alternate = "adminName")
    public String nickname;
    public String mail; // normal
    public String password;
    public String major; // normal
    public String sex; // normal
    private String courseName; // admin
    public String image;
    public String introduce; // normal
    public String grade; // normal
    public String registerTime;
    public String receiveMail; // normal
    public int firstLogin; // normal
    public String type; // admin
    public List<Direction> directionVOList; //normal

    static class Direction {
        public int courseId;
        public String userId;
        public String addTime;
        public String courseName;
    }

    public int getUserType() {
        if (type != null) {
            if ("admin".equals(type)) {
                return ADMIN;
            } else return SUPER_ADMIN;
        }
        return NORMAL;
    }
}
