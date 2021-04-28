package com.bg.lib_net;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * created by dr_chene on 2021/4/28
 * desc 以工厂模式创建不同的Retrofit对象
 */
public class RetrofitFactory {
    public static final String BASE_URL = "";
    //存储retrofit对象，防止重复创建
    public static final Map<Integer, Retrofit> retrofitMap = new HashMap<>();
    public static final int RETRO_NORMAL = 0;
    private static final String TAG = "RetrofitFactory";

    private RetrofitFactory() {
    }

    //用普通的retrofit创建连接
    public static <T> T createWithNormal(Class<T> service) {
        return create(RETRO_NORMAL).create(service);
    }

    private static Retrofit create(int type) {
        switch (type) {
            case RETRO_NORMAL:
                return create(RETRO_NORMAL, () -> new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build());
            default:
                throw new IllegalArgumentException("Unknown retrofit type!Check it carefully.");
        }
    }

    //一层校验锁创建retrofit
    private static Retrofit create(int type, RealCreate realCreate) {
        Retrofit normal = retrofitMap.get(type);
        if (normal == null) {
            synchronized (RetrofitFactory.class) {
                normal = realCreate.create();
                retrofitMap.put(type, normal);
            }
        }
        return normal;
    }

    private interface RealCreate {
        Retrofit create();
    }
}
