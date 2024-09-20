package com.example.submissiondicodingpemula

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.submissiondicodingpemula.data.HandphoneData

class DetailActivity : AppCompatActivity() {

    companion object{
        const val INFO_HP = "info_hp"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvmerk: TextView = findViewById(R.id.tv_merkDetail)
        val tvdesc: TextView =  findViewById(R.id.tv_descDetail)
        val ivdetail: ImageView = findViewById(R.id.iv_detail)

        val hp = if(Build.VERSION.SDK_INT>=33){
            intent.getParcelableExtra<HandphoneData>(INFO_HP, HandphoneData::class.java)
        }else{
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<HandphoneData>(INFO_HP)
        }

        if (hp != null) {
            tvmerk.text = hp.NamaHP
            tvdesc.text = hp.DescHP
            Glide.with(this)
                .load(hp.GambarHP)
                .into(ivdetail)
        }

    }
}