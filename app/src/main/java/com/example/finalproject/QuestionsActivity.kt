package com.example.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_questions.*

class QuestionsActivity : AppCompatActivity() {
    var db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        btnSend.setOnClickListener {
          pbSendQuestion.visibility=View.VISIBLE
            var name =  edYourName.text.toString()
            var question =  edQuestion.text.toString()
            pbSendQuestion.visibility= View.VISIBLE



         val q: MutableMap<String, Any> = HashMap()
         q["user name"] = name
         q["question"] = question

         db.collection("questions")
             .add(q)
             .addOnSuccessListener { documentReference ->
                 edYourName.setText("")
                 edQuestion.setText("")
                 pbSendQuestion.visibility=View.GONE

                 Log.d(
                     "TAG",
                     "DocumentSnapshot added with ID: " + documentReference.id
                 )
             }
             .addOnFailureListener {

                     e -> Log.w("TAG", "Error adding document", e)
                 edYourName.setText("")
                 edQuestion.setText("")
                 pbSendQuestion.visibility=View.GONE


             }



        }
    }
}