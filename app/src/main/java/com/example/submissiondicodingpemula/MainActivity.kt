package com.example.submissiondicodingpemula

import android.app.Notification.Action
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Html
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.submissiondicodingpemula.adapter.ListHpAdapter
import com.example.submissiondicodingpemula.data.HandphoneData

class MainActivity : AppCompatActivity() {
    private lateinit var rvHp: RecyclerView
    private val list = ArrayList<HandphoneData>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(3000)
        installSplashScreen()
        setContentView(R.layout.activity_main)






        rvHp = findViewById(R.id.rv_Handphone)
        rvHp.setHasFixedSize(true)

        list.addAll(getListHP())
        showRecyclerList()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                val pindahabout = Intent(this,AboutActivity::class.java)
                startActivity(pindahabout)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListHP(): ArrayList<HandphoneData>{
        val datamerkHp = resources.getStringArray(R.array.data_nama)
        val datadescHp = resources.getStringArray(R.array.data_desc)
        val dataGambar = resources.getStringArray(R.array.data_photo)
        val listHP = ArrayList<HandphoneData>()

        for (i in datamerkHp.indices){
            val hp = HandphoneData(datamerkHp[i], datadescHp[i], dataGambar[i])
            listHP.add(hp)
        }
        return listHP
    }

    private fun showRecyclerList(){
        rvHp.layoutManager = LinearLayoutManager(this)
        val listHpAdapter = ListHpAdapter(list)
        rvHp.adapter = listHpAdapter
    }

}