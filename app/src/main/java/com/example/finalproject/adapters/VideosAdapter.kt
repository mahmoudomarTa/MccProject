package com.example.finalproject.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.R
import com.example.finalproject.models.Video


class VideosAdapter(videoList: ArrayList<Video>, OnVideoClickListener: OnVideoClickListener) : RecyclerView.Adapter<VideosAdapter.ViewHolder>() {
    private val videoList: ArrayList<Video>
    private val mOnVideoClickListener: OnVideoClickListener

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.video_layout, viewGroup, false)
        return ViewHolder(view, mOnVideoClickListener)
    }

    override fun onBindViewHolder(viewholder: ViewHolder, position: Int) {
        val resource: Int = videoList[position].img
        val title: String = videoList[position].title
        viewholder.itemView.setOnClickListener {
            mOnVideoClickListener.OnVideoClicked(videoList[position].url)
        }
        viewholder.setData(resource, title)
    }

    override fun getItemCount(): Int {
        return videoList.size
    }

    class ViewHolder(itemView: View, OnVideoClickListener: OnVideoClickListener) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val imageView: ImageView
        private val title: TextView
        private val OnVideoClickListener: OnVideoClickListener
        fun setData(resource: Int, titleText: String) {
            imageView.setImageResource(resource)
            title.text = titleText
        }

        override fun onClick(view: View?) {
           // OnVideoClickListener.OnVideoClicked()
        }

        init {
            imageView = itemView.findViewById(R.id.imgVid)
            title = itemView.findViewById(R.id.tvVidTitle)
            this.OnVideoClickListener = OnVideoClickListener
            itemView.setOnClickListener(this)
        }
    }

    interface OnVideoClickListener {
        fun OnVideoClicked(url: String)
    }

    init {
        this.videoList = videoList
        mOnVideoClickListener = OnVideoClickListener
    }
}