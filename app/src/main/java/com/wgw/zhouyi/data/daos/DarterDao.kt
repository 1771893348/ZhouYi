package com.wgw.zhouyi.data.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.wgw.zhouyi.data.tables.Darter

/**
 * Author:Admin
 * Time:2021/3/11 15:06
 * 描述：
 */
@Dao
interface DarterDao {
    @Query("SELECT * FROM darter")
    fun getAllDarter():List<Darter>
    @Query("SELECT * FROM darter WHERE uid IN (:uids)")
    fun getDarterByUids(uids: IntArray):List<Darter>
    @Query("SELECT * FROM darter WHERE uid == (:uid)")
    fun getDarterByUids(uid: Int):Darter
    @Query("SELECT * FROM darter WHERE darter_name == :name")
    fun getDarterByUids(name: String):Darter
    @Insert
    fun insertDarter(darter: Darter)
    @Delete
    fun deleteDarter(darter: Darter)
}