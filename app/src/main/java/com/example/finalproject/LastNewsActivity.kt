package com.example.finalproject

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalproject.adapters.NewsAdapter
import kotlinx.android.synthetic.main.activity_last_news.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class LastNewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_last_news)


        var newsAdapter = NewsAdapter(object : NewsAdapter.OnNewsClickListener {
            override fun OnNewaClicked(url: String) {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(browserIntent)
            }
        })
        newsAdapter.setActivity(this)

        val data = ArrayList<Article>()
        GlobalScope.launch(Dispatchers.IO) {
            val response = ServiceBuilder.apis!!.getNews(
                "Jerusalem",
                "06731916cc4645b4acd2f5f319bdc99f",
                "ar"
            )
            withContext(Dispatchers.Main){
                data.addAll(response.body()!!.articles)
                print(data.size.toString())
                lastNewsRv.layoutManager=LinearLayoutManager(applicationContext)
                newsAdapter.setData(data)
                lastNewsRv.adapter=newsAdapter
                ppNews.visibility= View.GONE

            }
        }


    }
}