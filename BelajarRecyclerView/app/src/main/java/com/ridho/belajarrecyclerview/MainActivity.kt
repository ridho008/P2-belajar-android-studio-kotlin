package com.ridho.belajarrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // recycler view
        // numberAdapter()

        // menampilkan gambar melalui MainActivity
        // findViewById<ImageView>(R.id.imageView).setImageResource(R.drawable.black_widow)

        val images = listOf<Int>(
            R.drawable.black_panther,
            R.drawable.black_widow,
            R.drawable.hulk,
            R.drawable.spider
        )

        val imageAdapter = ImageAdapter(images)
        findViewById<RecyclerView>(R.id.recyclerView).adapter = imageAdapter
    }

    private fun textAdapter() {
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

        val textAdapter = TextAdapter(names)
        findViewById<RecyclerView>(R.id.recyclerView).adapter = textAdapter
    }

    private fun numberAdapter() {
        val numbers = listOf<Int>(
            1,2,3,4,5,6,7,8
        )



        val numberAdapter = NumberAdapter(numbers)
        findViewById<RecyclerView>(R.id.recyclerView).adapter = numberAdapter
    }
}