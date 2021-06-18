package com.example.finalproject.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.R
import com.example.finalproject.models.Most

class MostAdapter(data: ArrayList<Most>): RecyclerView.Adapter<MostAdapter.ViewHolder>() {
    private val data: ArrayList<Most>

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.most_layout, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewholder: ViewHolder, position: Int) {
        viewholder.setData(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val name: TextView
        private val text1: TextView
        fun setData( most: Most) {
            name.text = most.name
            text1.text = most.text
        }


        init {
            name = itemView.findViewById(R.id.tvName)
            text1 = itemView.findViewById(R.id.tvMostText)
        }

        override fun onClick(v: View?) {

        }
    }



    init {
        this.data = data
    }
}