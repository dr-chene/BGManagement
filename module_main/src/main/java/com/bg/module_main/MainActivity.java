package com.bg.module_main;

import com.bg.lib_base.view.BaseActivity;
import com.bg.module_main.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Override
    public void initView() {
        add("文章", R.drawable.ic_article);
        add("课程", R.drawable.ic_course);
        add("招新", R.drawable.ic_new);
        add("管理", R.drawable.ic_management);
        add("我的", R.drawable.ic_mine);
    }

    @Override
    public void initAction() {

    }

    @Override
    public int getContentViewResId() {
        return R.layout.activity_main;
    }

    private void add(String name, int res){
        binding.mainNavBottom.getMenu().add(name).setIcon(res);
    }
}