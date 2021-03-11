package com.wgw.zhouyi.data.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.wgw.zhouyi.data.tables.BeatTable

/**
 * Author:Admin
 * Time:2021/3/11 15:53
 * 描述：
 */
@Dao
interface BeatTableDao {
    @Query("SELECT * FROM beattable")
    fun getAllBeat():List<BeatTable>
    @Query("SELECT * FROM beattable WHERE bid == :bid")
    fun getBeatByBid(bid:Int):BeatTable

    @Insert
    fun insertBeatItem(beatTable: BeatTable)
    @Delete
    fun delectBeatItem(beatTable: BeatTable)
}