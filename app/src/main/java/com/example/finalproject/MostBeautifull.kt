package com.example.finalproject

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalproject.adapters.InfoAdapter
import com.example.finalproject.adapters.MostAdapter
import com.example.finalproject.models.Most
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_informations.*
import kotlinx.android.synthetic.main.activity_most_beautifull.*


class MostBeautifull : AppCompatActivity() {
    var data = ArrayList<Most>()
    var db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_most_beautifull)




        db.collection("most beautiful")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        var name  = document.data.get("name")
                        var text  = document.data.get("text")
                        data.add(Most(name as String, text as String))

                        Log.d("TAG", document.id + " => " + document.data)
                    }


                    var adapter = MostAdapter(data)
                    rcMost.adapter=adapter
                    rcMost.layoutManager= LinearLayoutManager(applicationContext)
                    ppMost.visibility= View.GONE

                } else {
                    Log.w("TAG", "Error getting documents.", task.exception)
                }
            }




    }
}