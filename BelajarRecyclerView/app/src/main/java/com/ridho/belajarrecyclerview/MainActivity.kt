package com.ridho.belajarrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // recycler view
        // numberAdapter()

        // menampilkan gambar melalui MainActivity
        // findViewById<ImageView>(R.id.imageView).setImageResource(R.drawable.black_widow)

        //imageAdapter()

        //textAdapter()

        modelAdapter()
    }

    // membuat adapter dengan menggunakan model
    private fun modelAdapter() {
        val movies = listOf<MovieModel>(
            MovieModel(1, "Black Panther", R.drawable.black_panther),
            MovieModel(2, "Black Widow", R.drawable.black_widow),
            MovieModel(3, "Hulk", R.drawable.hulk),
            MovieModel(4, "SpiderMan", R.drawable.spider)
        )

        // listener dengan menggunakan model
        val movieAdapter = MovieAdapter(movies, object : MovieAdapter.OnAdapterListener {
            override fun onClick(movie: MovieModel) {
                Log.e("MainActivity", movie.toString())
                Toast.makeText(applicationContext, movie.id.toString(), Toast.LENGTH_SHORT).show()
            }

        })
        findViewById<RecyclerView>(R.id.recyclerView).adapter = movieAdapter
    }

    public fun imageAdapter() {
        val images = listOf<Int>(
            R.drawable.black_panther,
            R.drawable.black_widow,
            R.drawable.hulk,
            R.drawable.spider
        )

        val imageAdapter = ImageAdapter(images)
        // findViewById<RecyclerView>(R.id.recyclerView).layoutManager = LinearLayoutManager(this)
        // set layout manager
        // ketika tdk menggunakan layout manager di activity_main.xml
//        findViewById<RecyclerView>(R.id.recyclerView).apply {
//            layoutManager = GridLayoutManager(this@MainActivity, 2)
//            adapter = imageAdapter
//        }

        findViewById<RecyclerView>(R.id.recyclerView).adapter = imageAdapter
    }

    private fun textAdapter() {
        val names = listOf<String>(
            "Nani", "Ronaldo",
            "Toni", "Dewi",
            "Rani", "Harun",
            "Wani", "Wantani"
        )

        // jika data yang diambil tidak dapat, gunakan Log.e ini untuk men-debungging
//        Log.e("MainActivity", "size ${names.size}")
//        Log.e("MainActivity", names[1])

        // menggunakan foreach
        // it, menjadi variabel yang telah dipecah / gunakan name utk mempresentasikan var yg diambil
        names.forEach { name ->
            Log.e("MainActivity", name)
        }

        val textAdapter = TextAdapter(names, object : TextAdapter.OnAdapterListener {
            override fun onClick(name: String) {
                Toast.makeText(applicationContext, name, Toast.LENGTH_SHORT).show()
            }

        })
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