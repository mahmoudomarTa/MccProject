package com.example.finalproject.adapters

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.finalproject.Article
import com.example.finalproject.R
import kotlinx.android.synthetic.main.item_in_last_news.view.*


class NewsAdapter(OnNewsClickListener: NewsAdapter.OnNewsClickListener) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    private lateinit var activity:Activity
    private lateinit var data: ArrayList<Article>
    private val mOnNewsClickListener: NewsAdapter.OnNewsClickListener

    fun setActivity(activity1:Activity){
        activity=activity1
    }

    fun setData(data1: ArrayList<Article>){
        data=data1
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_in_last_news, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewholder: ViewHolder, position: Int) {
        //val title: String = data[position]
        viewholder.itemView.setOnClickListener {
            mOnNewsClickListener.OnNewaClicked(data[position].url)
        }
        Glide
            .with(activity)
            .load(data[position].urlToImage)
            .centerCrop()
            .placeholder(R.drawable.load)
            .into(viewholder.itemView.findViewById(R.id.imageView));
        viewholder.setData(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var tvAuthor = itemView.tvAuthor
        var tvPublishedAt: TextView= itemView.tvPublishedAt
        var tvtitle: TextView= itemView.tvtitle
        var tvContent: TextView= itemView.tvContent
        var tvDescription: TextView= itemView.tvDescription
        fun setData( article:Article) {
            tvAuthor.text=article.author
            tvPublishedAt.text=article.publishedAt
            tvtitle.text=article.title
            tvContent.text=article.content
            tvDescription.text=article.description
        }



        override fun onClick(v: View?) {
            
        }
    }

    interface OnNewsClickListener {
        fun OnNewaClicked(url: String)
    }

    init {
        mOnNewsClickListener = OnNewsClickListener
    }
}