package com.bg.module_demo;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bg.lib_base.view.BaseActivity;
import com.bg.module_demo.databinding.ActivityDemoBinding;

import kotlin.Lazy;

import static org.koin.java.KoinJavaComponent.inject;

@Route(path = "/activity/demo")
public class DemoActivity extends BaseActivity<ActivityDemoBinding> {

    private final Lazy<DemoDao> dao = inject(DemoDao.class);

    @Override
    public void initView() {

    }

    @Override
    public void initAction() {
        binding.demoInsert.setOnClickListener(v -> { insert(); });
        binding.demoQuery.setOnClickListener(v -> { query(); });
    }

    @Override
    public int getContentViewResId() {
        return R.layout.activity_demo;
    }

    private void insert(){
        new Thread(() -> {
            String content = binding.demoInput.getText().toString();
            dao.getValue().insert(new DemoBean(content, System.currentTimeMillis()));
            runOnUiThread(() -> binding.demoInput.setText(""));
        }).start();
    }

    private void query(){
        new Thread(() -> {
            String content = dao.getValue().getDemos().toString();
            runOnUiThread(() -> binding.demoTest.setText(content));
        }).start();
    }
}