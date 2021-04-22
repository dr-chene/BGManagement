package com.bg.module_demo;

import com.bg.lib_base.view.BaseActivity;
import com.bg.module_demo.databinding.ActivityDemoBinding;

import kotlin.Lazy;

import static org.koin.java.KoinJavaComponent.inject;

public class DemoActivity extends BaseActivity<ActivityDemoBinding> {

    private final Lazy<DemoDao> dao = inject(DemoDao.class);

    @Override
    public void initView() {
        DemoDao d = dao.getValue();
    }

    @Override
    public void initAction() {

    }

    @Override
    public int getContentViewResId() {
        return R.layout.activity_demo;
    }
}