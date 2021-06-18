package com.example.finalproject.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.R


class InfoAdapter(data: ArrayList<String>) : RecyclerView.Adapter<InfoAdapter.ViewHolder>() {
    private val data: ArrayList<String>

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.info_layout, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewholder: ViewHolder, position: Int) {
        val title: String = data[position]
        viewholder.setData(title)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val text1: TextView
        fun setData( text: String) {
            text1.text = text
        }


        init {
            text1 = itemView.findViewById(R.id.tvInfo)
        }

        override fun onClick(v: View?) {

        }
    }



    init {
        this.data = data
    }
}