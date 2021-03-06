package com.wgw.zhouyi

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import com.wgw.zhouyi.data.database.AppDatabase

/**
 * Author:Admin
 * Time:2021/3/11 15:40
 * 描述：
 */
class App :Application(){
    val db = Room.databaseBuilder(this, AppDatabase::class.java, "database-name").build()
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
    }

    override fun onCreate() {
        super.onCreate()
    }

    fun getDB(): AppDatabase {
        return db
    }
}