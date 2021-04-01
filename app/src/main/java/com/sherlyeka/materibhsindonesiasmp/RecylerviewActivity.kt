package com.sherlyeka.materibhsindonesiasmp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecylerviewActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recylerview)

        init()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun init() {
        recyclerView = findViewById(R.id.recycler_view)

        var data = ArrayList<SocialMedia>()
        data.add(SocialMedia("Variasi kalimat perintah, saran, ajakan, larangan dalam pantun", "Kelas VII"))
        data.add(SocialMedia( "Ciri cerita fabel/ legenda","Kelas VII"))
        data.add(SocialMedia( "Pengertian teks berita", "Kelas VIII"))
        data.add(SocialMedia( "Unsur-unsur teks eksposisi: gagasan dan fakta-fakta.", "Kelas VIII"))
        data.add(SocialMedia( "Fungi teks diskusi", "Kelas IX"))

        adapter = MyAdapter(data)
    }
}