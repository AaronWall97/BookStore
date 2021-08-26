package com.example.bookstore


import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import de.hdodenhof.circleimageview.CircleImageView
import android.content.SharedPreferences
import android.util.Log
import android.widget.Button
import java.io.IOException


class ProfileActivity : AppCompatActivity() {

    private lateinit var profileImage : CircleImageView
    private lateinit var saveButton : Button

    companion object {
        private const val SELECT_IMAGE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)


        profileImage = findViewById(R.id.circle_image_view)
        saveButton = findViewById(R.id.save)


        setSupportActionBar(findViewById(R.id.include))

        val actionBar : ActionBar? = supportActionBar

        actionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        profileImage.setOnClickListener{
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(intent,"Select Picture"), SELECT_IMAGE)
        }



    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


    @SuppressLint("MissingSuperCall")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == SELECT_IMAGE) {
            if (resultCode == Activity.RESULT_OK){
                if(data != null){
                    try{
                        val selectedImage = data.data
                        val yourSelectedImage = BitmapFactory.decodeStream(contentResolver.openInputStream(selectedImage!!))
                        profileImage.setImageBitmap(yourSelectedImage)
                    }catch(e : IOException){
                        Log.e("ProfileActivity","The image is not loaded : $e")
                    }

                }
            }
        }
    }
}