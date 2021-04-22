package com.bg.lib_base.view;

/**
 * created by dr_chene on 2021/4/22
 * desc
 */
public interface IBaseView {
    void initView();

    void initAction();

    default void subscribe(){}

    int getContentViewResId();
}
