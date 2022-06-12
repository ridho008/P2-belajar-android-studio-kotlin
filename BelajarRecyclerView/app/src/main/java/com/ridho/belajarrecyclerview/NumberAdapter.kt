package com.ridho.belajarrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NumberAdapter(
    private val listName: List<Int>
) :RecyclerView.Adapter<NumberAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_main, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NumberAdapter.ViewHolder, position: Int) {
        // holder.text.text = listName[position].toString()
        holder.text.text = "${listName[position]}"
    }

    override fun getItemCount(): Int {
        return listName.size
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val text = view.findViewById<TextView>(R.id.textView)
    }
}