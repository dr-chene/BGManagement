package com.bg.lib_base.view;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/**
 * j
 * created by dr_chene on 2021/4/22
 * desc activity基类
 */
public abstract class BaseActivity<T extends ViewDataBinding> extends AppCompatActivity implements IBaseView {
    protected final String TAG = this.getClass().getSimpleName();
    protected T binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        makeStatusBarTransparent();
        makeStatusBarIconDark();

        binding = DataBindingUtil.setContentView(this, getContentViewResId());
        initView();
        initAction();
        subscribe();
    }

    //使状态栏透明
    private void makeStatusBarTransparent() {
        Log.d(TAG, "makeStatusBarTransparent: ");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            int option = getWindow().getDecorView().getSystemUiVisibility() | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            getWindow().getDecorView().setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }

    //使状态栏的图标呈深色
    protected void makeStatusBarIconDark() {
        Log.d(TAG, "makeStatusBarIconDark: ");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int option = getWindow().getDecorView().getSystemUiVisibility();
            getWindow().getDecorView().setSystemUiVisibility(option | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            getWindow().setStatusBarColor(Color.parseColor("#80EEEEEE"));
        }
    }
}
