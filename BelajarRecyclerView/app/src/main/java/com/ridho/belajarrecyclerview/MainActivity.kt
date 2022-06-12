package com.ridho.belajarrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val names = listOf<String>(
            "Nani",
            "Toni",
            "Rani",
            "Wani"
        )

        // jika data yang diambil tidak dapat, gunakan Log.e ini untuk men-debungging
//        Log.e("MainActivity", "size ${names.size}")
//        Log.e("MainActivity", names[1])

        // menggunakan foreach
        // it, menjadi variabel yang telah dipecah / gunakan name utk mempresentasikan var yg diambil
        names.forEach { name ->
            Log.e("MainActivity", name)
        }

        val numbers = listOf<Int>(
            1,2,3,4,5,6,7,8
        )

        val mainAdapter = MainAdapter(numbers)
        findViewById<RecyclerView>(R.id.recyclerView).adapter = mainAdapter
    }
}