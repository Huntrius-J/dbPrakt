package com.example.dbprakt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class recyclerAdapter (val context: Context, val list: List<Article>) :RecyclerView.Adapter<recyclerAdapter.ViewHolder>() {
    class ViewHolder(val view: View): RecyclerView.ViewHolder(view)
    {
        val iTitle: TextView = view.findViewById(R.id.iTitle)
        val iContent: TextView = view.findViewById(R.id.iContent)
    }
        val inflater = LayoutInflater.from(context)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.recycler_item, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.iTitle.text = list[position].title.toString()
        holder.iContent.text = list[position].content.toString()
    }

    override fun getItemCount(): Int {
        return list.size
    }
}