package com.bg.bgmanagement

import org.koin.dsl.module

/**
 * created by dr_chene on 2021/4/22
 * desc koin库
 */

val appModule = module {
    single { AppDataBase.buildDataBase(get()) }
    single { get<AppDataBase>().demoDao }
}
