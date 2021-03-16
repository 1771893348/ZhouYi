package com.wgw.zhouyi.match.activitys

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import com.wgw.zhouyi.R
import java.io.File
import java.io.FileOutputStream


/**
 * Author:Admin
 * Time:2021/3/11 16:24
 * 描述：
 */
class MatchMainActivity :AppCompatActivity(){
    //调用照相机返回图片文件
    private var tempFile: File ?= null
    companion object{
        //相册请求码
        private val ALBUM_REQUEST_CODE = 1
        //相机请求码
        private val CAMERA_REQUEST_CODE = 2
        //裁剪请求码
        private val CROP_REQUEST_CODE = 3
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matchmain)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            CAMERA_REQUEST_CODE -> if (resultCode === RESULT_OK) {
                //用相机返回的照片去调用剪裁也需要对Uri进行处理
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    val contentUri = FileProvider.getUriForFile(
                        this, "com.hansion.chosehead",
                        tempFile!!
                    )
                    cropPhoto(contentUri)
                } else {
                    cropPhoto(Uri.fromFile(tempFile))
                }
            }
            ALBUM_REQUEST_CODE -> if (resultCode === RESULT_OK) {
                val uri = intent.data
                cropPhoto(uri!!)
            }
            CROP_REQUEST_CODE -> {
                val bundle = intent.extras
                if (bundle != null) {
                    //在这里获得了剪裁后的Bitmap对象，可以用于上传
                    val image = bundle.getParcelable<Bitmap>("data")
                    //设置到ImageView上
                    //也可以进行一些保存、压缩等操作后上传
//                    String path = saveImage("crop", image);
                }
            }
        }
    }

    fun getPicFromCamera(){
        tempFile = File(
            Environment.getStorageDirectory().path,
            System.currentTimeMillis().toString() + ".jpg"
        )
        var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        //判断版本
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {   //如果在Android7.0以上,使用FileProvider获取Uri
            intent.flags = Intent.FLAG_GRANT_WRITE_URI_PERMISSION
            val contentUri: Uri = FileProvider.getUriForFile(
                this, "com.hansion.chosehead",
                tempFile!!
            )
            intent.putExtra(MediaStore.EXTRA_OUTPUT, contentUri)
            Log.e("dasd", contentUri.toString())
        } else {    //否则使用Uri.fromFile(file)方法获取Uri
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(tempFile))
        }
        startActivityForResult(intent, CAMERA_REQUEST_CODE)
    }
    fun getPicFromAlbm(){
        var phonePickerIntent = Intent(Intent.ACTION_PICK)
        phonePickerIntent.setType("image/*")
        startActivityForResult(phonePickerIntent, ALBUM_REQUEST_CODE)
    }

    /**
     * 裁剪图片
     */
    private fun cropPhoto(uri: Uri) {
        val intent = Intent("com.android.camera.action.CROP")
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
        intent.setDataAndType(uri, "image/*")
        intent.putExtra("crop", "true")
        intent.putExtra("aspectX", 1)
        intent.putExtra("aspectY", 1)
        intent.putExtra("outputX", 300)
        intent.putExtra("outputY", 300)
        intent.putExtra("return-data", true)
        startActivityForResult(intent, CROP_REQUEST_CODE)
    }

    fun saveImage(name:String,bmp:Bitmap):String{
        val appDir = File(Environment.getStorageDirectory().path)
        if (!appDir.exists()){
            appDir.mkdir()
        }
        val fileName = name + ".jpg";
        var file = File(appDir,fileName)
        try {
            var fos = FileOutputStream(file)
            bmp.compress(Bitmap.CompressFormat.PNG,100,fos)
            fos.flush()
            fos.close()
            return file.absolutePath
        } catch (e:Exception){
            e.printStackTrace()
        }
        return ""
    }
}