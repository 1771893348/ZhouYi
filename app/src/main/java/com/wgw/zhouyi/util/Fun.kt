package com.wgw.zhouyi.util

import java.io.*

/**
 * Author:Admin
 * Time:2021/3/9 14:28
 * 描述：
 */
class Fun {
    companion object {
        fun readTxt(strFilePath:String):String{
            var content:String = ""
            val file = File(strFilePath)
            if (file.isDirectory){

            }else{
                try {
                    val instream:InputStream = FileInputStream(file)
                    if (null != instream){
                        var line:String?=null
                       var bufferedReader = BufferedReader(InputStreamReader(instream,"UTF-8"))
                        while (bufferedReader.readLine().also { line=it }!=null){

                        }
                    }
                }catch (e:Exception){

                }
            }
            return content
        }
    }
}