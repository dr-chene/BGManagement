package com.bg.bgmanagement

import com.alibaba.android.arouter.launcher.ARouter
import com.bg.lib_base.BaseApp
import com.tencent.mmkv.MMKV
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

/**
 * created by dr_chene on 2021/4/22
 * desc app类，做些三方库的初始化
 */
class App : BaseApp() {
    override fun onCreate() {
        super.onCreate()
        MMKV.initialize(this)

        startKoin {
            androidLogger(level = Level.DEBUG)
            androidContext(this@App)
            modules(appModule)
        }

        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }
}