package com.example.finalproject

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalproject.adapters.InfoAdapter
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_informations.*


class InformationsActivity : AppCompatActivity() {
    var db = FirebaseFirestore.getInstance()
    var data = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informations)






        db.collection("informations")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {

                        data.add(document.data.get("info") as String)

                        Log.d("TAG", document.id + " => " + document.data)
                    }


                    var adapter = InfoAdapter(data)
                    rcInfo.adapter=adapter
                    rcInfo.layoutManager=LinearLayoutManager(applicationContext)
                    ppInfo.visibility=View.GONE
                } else {
                    Log.w("TAG", "Error getting documents.", task.exception)
                }
            }
    }
}