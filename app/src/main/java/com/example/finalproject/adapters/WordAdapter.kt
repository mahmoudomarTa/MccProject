package com.example.finalproject.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.R
import com.example.finalproject.models.Word


class WordAdapter(wordList: ArrayList<Word>, OnWordClickListener: OnWordClickListener) : RecyclerView.Adapter<WordAdapter.ViewHolder>() {
    private val wordList: ArrayList<Word>
    private val mOnWordClickListener: OnWordClickListener

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view: View =LayoutInflater.from(viewGroup.context).inflate(R.layout.item_in_main_rc, viewGroup, false)
        return ViewHolder(view, mOnWordClickListener)
    }

    override fun onBindViewHolder(viewholder: ViewHolder, position: Int) {
        val resource: Int = wordList[position].imageRec
        val title: String = wordList[position].text
        viewholder.setData(resource, title)
    }

    override fun getItemCount(): Int {
        return wordList.size
    }

    class ViewHolder(itemView: View, OnWordClickListener: OnWordClickListener) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val imageView: ImageView
        private val title: TextView
        private val OnWordClickListener: OnWordClickListener
        fun setData(resource: Int, titleText: String) {
            imageView.setImageResource(resource)
            title.text = titleText
        }

        override fun onClick(view: View?) {
            OnWordClickListener.OnWordClicked(adapterPosition)
        }

        init {
            imageView = itemView.findViewById(R.id.img_rc_main)
            title = itemView.findViewById(R.id.tv_rc_main)
            this.OnWordClickListener = OnWordClickListener
            itemView.setOnClickListener(this)
        }
    }

    interface OnWordClickListener {
        fun OnWordClicked(position: Int)
    }

    init {
        this.wordList = wordList
        mOnWordClickListener = OnWordClickListener
    }
}