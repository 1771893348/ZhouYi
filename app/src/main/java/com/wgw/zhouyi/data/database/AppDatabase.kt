package com.wgw.zhouyi.data.database

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.wgw.zhouyi.data.daos.BeatTableDao
import com.wgw.zhouyi.data.daos.DarterDao
import com.wgw.zhouyi.data.tables.BeatTable
import com.wgw.zhouyi.data.tables.Darter

/**
 * Author:Admin
 * Time:2021/3/11 15:36
 * 描述：
 */
@Database(entities= arrayOf(Darter::class,BeatTable::class),version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun darterDao():DarterDao
    abstract fun beatTableDao():BeatTableDao
    companion object{
        private var instance:AppDatabase ?= null
        fun getInstance(context: Context):AppDatabase{
            if (null == instance){
                instance = Room.databaseBuilder(context,AppDatabase::class.java,"darter.db")
                    .allowMainThreadQueries()
                    .addCallback(object : Callback(){
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            Log.i("wgw_db","onCreate")
                            super.onCreate(db)
                        }

                        override fun onOpen(db: SupportSQLiteDatabase) {
                            Log.i("wgw_db","onOpen")
                            super.onOpen(db)
                        }

                        override fun onDestructiveMigration(db: SupportSQLiteDatabase) {
                            super.onDestructiveMigration(db)
                        }
                    })
                    .build()
            }
            return instance!!
        }
    }
}