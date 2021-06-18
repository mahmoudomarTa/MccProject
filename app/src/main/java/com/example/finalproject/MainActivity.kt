package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.finalproject.adapters.WordAdapter
import com.example.finalproject.models.Word
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var words = ArrayList<Word>()
        words.add(Word(R.drawable.news,"last news"))
        words.add(Word(R.drawable.map,"jerusalem location"))
        words.add(Word(R.drawable.info,"information"))
        words.add(Word(R.drawable.say,"most beautiful about jerusalem"))
        words.add(Word(R.drawable.videos,"jerusalem Videos"))
        words.add(Word(R.drawable.ask,"ask an expert"))


        var mainAdapter = WordAdapter(words,object :WordAdapter.OnWordClickListener{
            override fun OnWordClicked(position: Int) {
                if (words[position].text.equals("last news")){
                    var i = Intent(applicationContext,LastNewsActivity::class.java)
                    startActivity(i)
                }else if (words[position].text.equals("jerusalem location")){
                    var i = Intent(applicationContext,MapsActivity::class.java)
                    startActivity(i)
                }else if (words[position].text.equals("information")){
                    var i = Intent(applicationContext,InformationsActivity::class.java)
                    startActivity(i)
                }else if (words[position].text.equals("most beautiful about jerusalem")){
                    var i = Intent(applicationContext,MostBeautifull::class.java)
                    startActivity(i)
                }else if (words[position].text.equals("jerusalem Videos")){
                    var i = Intent(applicationContext,VideoActivity::class.java)
                    startActivity(i)
                }else if (words[position].text.equals("ask an expert")){
                    var i = Intent(applicationContext,QuestionsActivity::class.java)
                    startActivity(i)
                }
            }
        })

        rcMain.adapter=mainAdapter
        rcMain.layoutManager=GridLayoutManager(applicationContext,2)


    }
}