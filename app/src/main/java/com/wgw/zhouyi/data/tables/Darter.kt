package com.wgw.zhouyi.data.tables

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Author:Admin
 * Time:2021/3/11 14:43
 * 描述：
 */
@Entity
data class Darter(
        @PrimaryKey val uid:Int,
        @ColumnInfo(name="darter_name") var darter_name:String?,
        @ColumnInfo(name = "darter_info") var darter_info:String?,
        @ColumnInfo(name="darter_icon") var darter_icon:String?,
        @ColumnInfo(name="darter_sex") var darter_sex:String
)
