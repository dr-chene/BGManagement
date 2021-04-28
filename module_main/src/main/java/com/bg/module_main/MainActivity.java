package com.bg.module_main;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bg.lib_base.BaseApp;
import com.bg.lib_base.bean.User;
import com.bg.lib_base.view.BaseActivity;
import com.bg.module_main.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Override
    public void initView() {
        initNavBottom();

    }

    @Override
    public void initAction() {
        Log.d("TAG", "initAction: " + (BaseApp.user == null));
    }

    @Override
    public int getContentViewResId() {
        return R.layout.activity_main;
    }

    private void initNavBottom(){
        add("文章", R.drawable.ic_article);
        add("课程", R.drawable.ic_course);
        add("招新", R.drawable.ic_new);
        if (BaseApp.userType <= User.ADMIN) add("管理", R.drawable.ic_management);
        add("我的", R.drawable.ic_mine);
    }

    private void add(String name, int res){
        binding.mainNavBottom.getMenu().add(name).setIcon(res);
    }

    private void initViewPager(){
        binding.mainViewPager.setUserInputEnabled(false);
        binding.mainViewPager.setAdapter(new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                return null;
            }

            @Override
            public int getItemCount() {
                return 4;
            }
        });
    }
}