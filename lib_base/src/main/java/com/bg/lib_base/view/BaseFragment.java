package com.bg.lib_base.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

/**
 * created by dr_chene on 2021/4/22
 * desc fragment基类
 */
public abstract class BaseFragment<T extends ViewDataBinding> extends Fragment implements IBaseView {
    protected final String TAG = this.getClass().getSimpleName();
    protected T binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, getContentViewResId(), container, false);

        initView();
        initAction();
        subscribe();

        return binding.getRoot();
    }
}
