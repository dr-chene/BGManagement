package com.bg.lib_base.view;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/**j
 * created by dr_chene on 2021/4/22
 * desc activity基类
 */
public abstract class BaseActivity<T extends ViewDataBinding> extends AppCompatActivity implements IBaseView{
    protected final String TAG = this.getClass().getSimpleName();
    protected T binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        binding = DataBindingUtil.setContentView(this, getContentViewResId());
        initView();
        initAction();
        subscribe();
    }
}
