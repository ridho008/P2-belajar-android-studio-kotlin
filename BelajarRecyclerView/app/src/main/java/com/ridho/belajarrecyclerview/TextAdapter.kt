package com.ridho.belajarrecyclerview

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class TextAdapter(
    //private val context: Context,
    private val listName: List<String>,
    private val listener: OnAdapterListener,
) :RecyclerView.Adapter<TextAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_main, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TextAdapter.ViewHolder, position: Int) {
        val name = listName[position]
        holder.textView.text = name
        holder.textView.setOnClickListener {
            Log.e("TextAdapter", name)
            //Toast.makeText(context,name, Toast.LENGTH_SHORT).show()
            listener.onClick(name)
        }
    }

    override fun getItemCount(): Int {
        return listName.size
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val container = view.findViewById<ConstraintLayout>(R.id.container)
        val textView = view.findViewById<TextView>(R.id.textView)
    }

    interface OnAdapterListener {
        fun onClick(name: String)
    }
}