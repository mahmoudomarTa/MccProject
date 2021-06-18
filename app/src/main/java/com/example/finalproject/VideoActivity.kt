package com.example.finalproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalproject.adapters.VideosAdapter
import com.example.finalproject.models.Video
import kotlinx.android.synthetic.main.activity_video.*

class VideoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        rcVideos.layoutManager=LinearLayoutManager(applicationContext)
        var data = ArrayList<Video>()
        data.add(
            Video(
                R.drawable.v1,
                "ما هي القدس | فلسطين",
                "https://d.top4top.io/m_1995nnbha0.mp4"
            )
        )
        data.add(
            Video(
                R.drawable.v2,
                "اصابة المصلين في مواجهات الاقصى",
                "https://j.top4top.io/m_19955rqxm0.mp4"
            )
        )
        data.add(
            Video(
                R.drawable.v3,
                "الحركات الفلسطينية تهدد برد قاسي على الاعتداءات الصهيونية",
                "https://f.top4top.io/m_19953av1g0.mp4"
            )
        )
        data.add(
            Video(
                R.drawable.v4,
                "الفلسطسنيون يحتفلون بازالة الحواجز عند باب العامود",
                "https://d.top4top.io/m_1995qcj3a0.mp4"
            )
        )
        data.add(
            Video(
                R.drawable.v5,
                "اخر تطورات مجريات هبة القدس",
                "https://c.top4top.io/m_1995o7cge0.mp4"
            )
        )
        data.add(
            Video(
                R.drawable.v6,
                "نتنياهو يبحث تطورات الموقف في غزة والقدس",
                "https://f.top4top.io/m_19955rlpf0.mp4"
            )
        )
        data.add(
            Video(
                R.drawable.v7,
                "أولى القبلتين وثالث الحرمين .. تعرف عليه",
                "https://i.top4top.io/m_19958a80l0.mp4"
            )
        )
        data.add(
            Video(
                R.drawable.v8,
                "53 اصابة في المواجهات مع جيش الاحتلال",
                "https://f.top4top.io/m_1995x2dim0.mp4"
            )
        )
        data.add(
            Video(
                R.drawable.v9,
                "قوات الاحتلال تعتدي على الفلسطينين في القدس المحتلة",
                "https://c.top4top.io/m_1995wc9tc0.mp4"
            )
        )
        data.add(
            Video(
                R.drawable.v10,
                "ما لا تعرفه عن المسجد الاقصى",
                    "https://c.top4top.io/m_1995usoxq0.mp4"
            )
        )
        data.add(
            Video(
                R.drawable.v11,
                "القدس عاصمة المقاومة الفلسطينية",
                "https://c.top4top.io/m_1995usoxq0.mp4"
            )
        )



        var adapter = VideosAdapter(data, object : VideosAdapter.OnVideoClickListener {
            override fun OnVideoClicked(url: String) {
                val i = Intent(applicationContext, RunVideoActivity::class.java)
                i.putExtra("uri",url)
                startActivity(i)

            }
        })
        rcVideos.adapter=adapter
        rcVideos.layoutManager=LinearLayoutManager(applicationContext)



    }
}