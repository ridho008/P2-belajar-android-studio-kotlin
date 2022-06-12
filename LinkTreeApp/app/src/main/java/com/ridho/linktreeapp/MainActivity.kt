package com.ridho.linktreeapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // menghilangkan tobar
        supportActionBar!!.hide()

        // mengambil id di file activity_main.xml
        val image = findViewById<ImageView>(R.id.image)
        val title = findViewById<TextView>(R.id.title)
        val subtitle = findViewById<TextView>(R.id.subtitle)
        val list = findViewById<RecyclerView>(R.id.list)

        image.setImageResource(R.drawable.my_photo)
        title.text = "Ridho Surya"
        subtitle.text = "Web Development"

        list.adapter = linkAdapter
    }

    private val linkAdapter by lazy {
        val items = listOf<LinkModel>(
            LinkModel("WhatsApp", R.drawable.wa, "https://api.whatsapp.com/send?phone=085272773873"),
            LinkModel("Instagram", R.drawable.ig, "https://www.instagram.com/ridho_ssss/"),
            LinkModel("Facebook", R.drawable.fb, "https://www.facebook.com/ridho.ambara/"),
            LinkModel("Youtube", R.drawable.yt, "https://www.youtube.com/channel/UCRb_-8pyWHiF3XRtcb8Yxfg"),
            LinkModel("Website", R.drawable.web, "https://inforlajar.blogspot.com/")
        )

        LinkAdapter(items, object : LinkAdapter.AdapterListener {
            override fun onClick(linktree: LinkModel) {
                Log.e("onClick", linktree.url)
                openUrl(linktree.url)
            }

        })
    }

    private fun openUrl(url: String) {
        val openUrl = Intent(Intent.ACTION_VIEW)
        openUrl.data = Uri.parse(url)
        startActivity(openUrl)
    }
}