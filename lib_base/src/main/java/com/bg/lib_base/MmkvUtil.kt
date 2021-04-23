package com.bg.lib_base

import com.bg.lib_base.bean.User
import com.google.gson.Gson
import com.tencent.mmkv.MMKV
import org.koin.java.KoinJavaComponent.inject

/**
 * created by dr_chene on 2021/4/23
 * desc 存取user
 */
object MmkvUtil {
    private const val USER = "user"
    private val kv = MMKV.defaultMMKV()
    private val gson by lazy { Gson() }

    fun saveUser(user: User) {
        val content = gson.toJson(user)
        kv.encode(USER, content)
    }

    val user: User?
        get() = gson.fromJson(kv.decodeString(USER), User::class.java)
}