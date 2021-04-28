package com.bg.lib_net;

import com.bg.lib_base.BaseApp;
import com.bg.lib_net.bean.ApiResult;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * created by dr_chene on 2021/4/28
 * desc 数据请求封装类
 */
public class DataRequest {

    private static final RequestError requestError = Throwable::printStackTrace;
    private static final ShouldFetch shouldFetch = new ShouldFetch() {
        @Override
        public <T> boolean shouldFetch(T t) {
            return BaseApp.isConnected;
        }
    };
    private static Disposable localRequest;
    private static Disposable apiRequest;

    //带本地存储的数据请求
    public static <T> void requestWithRoom(Single<List<T>> local, Single<ApiResult<T>> remote, RequestSuccess success) {
        requestWithRoom(local, remote, shouldFetch, success, requestError);
    }

    public static <T> void requestWithRoom(Single<List<T>> local, Single<ApiResult<T>> api, ShouldFetch shouldFetch, RequestSuccess success, RequestError error) {
        if (local == null) {
            requestWithoutRoom(api, success, error);
            return;
        }
        localRequest = local.subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(data -> {
                    if (data.isEmpty() || shouldFetch.shouldFetch(data.get(0))) {
                        requestWithoutRoom(api, success, error);
                    } else {
                        success.dispatch(data.get(0));
                        if (localRequest != null && !localRequest.isDisposed()) {
                            localRequest.dispose();
                        }
                        localRequest = null;
                    }
                }, error::onError);
    }

    //不带本地存储的数据请求
    public static <T> void requestWithoutRoom(Single<ApiResult<T>> api, RequestSuccess success) {
        requestWithoutRoom(api, success, requestError);
    }

    public static <T> void requestWithoutRoom(Single<ApiResult<T>> api, RequestSuccess success, RequestError error) {
        apiRequest = api.subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(apiResult -> {
                    if (apiResult.errorCode == 200) {
                        success.dispatch(apiResult.data);
                    } else {
                        success.error(apiResult.errorCode, apiResult.errorMsg);
                    }
                    if (apiRequest != null && !apiRequest.isDisposed()) {
                        apiRequest.dispose();
                    }
                    apiRequest = null;
                }, error::onError);
    }

    public interface ShouldFetch {
        <T> boolean shouldFetch(T t);
    }

    public interface RequestSuccess {
        <T> void dispatch(T result);

        void error(int code, String message);
    }

    public interface RequestError {
        void onError(Throwable t);
    }

}
