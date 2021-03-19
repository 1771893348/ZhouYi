package com.wgw.zhouyi

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import com.wgw.zhouyi.data.database.AppDatabase

/**
 * Author:Admin
 * Time:2021/3/11 15:40
 * 描述：
 */
class App :Application(){
    var db:AppDatabase?=null
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
    }

    override fun onCreate() {
        db = Room.databaseBuilder(this, AppDatabase::class.java, "darter.db").build()
        super.onCreate()


    }

    fun getDB(): AppDatabase {
        if (null == db) {
            Log.i("wgw_db","db is null")
        }
        return db!!
    }
}