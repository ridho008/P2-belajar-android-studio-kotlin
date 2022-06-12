package com.ridho.linktreeapp

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LinkAdapter (
    val items: List<LinkModel>,
    val listener: AdapterListener,

) : RecyclerView.Adapter<LinkAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        // ambil idnya di file adapter_link.xml
        val image = itemView.findViewById<ImageView>(R.id.image)
        val title = itemView.findViewById<TextView>(R.id.title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        // memanggil layout adapter_link
        LayoutInflater.from(parent.context).inflate(R.layout.adapter_link, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.image.setImageResource(item.image)
        holder.title.text = item.title

        // ketika url diklik
        holder.itemView.setOnClickListener {
            listener.onClick(item)
        }
    }

    override fun getItemCount(): Int = items.size

    interface AdapterListener {
        fun onClick(linktree: LinkModel)
    }
}