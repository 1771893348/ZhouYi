package com.wgw.zhouyi.data.tables

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Author:Admin
 * Time:2021/3/11 14:54
 * 描述：
 */
@Entity
data class BeatTable(
    @PrimaryKey val bid:Int?,
    @ColumnInfo(name="red_uid") val red_uid:Int,
    @ColumnInfo(name="blu_uid") val blu_uid:Int,
    @ColumnInfo(name = "date_time") val date_time:String
)
