package com.wgw.zhouyi.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
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
}