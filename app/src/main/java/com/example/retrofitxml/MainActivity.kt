package com.example.retrofitxml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitxml.model.Feed
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.retrofitxml.model.entry.Entry


class MainActivity : AppCompatActivity() {

    lateinit var rv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv = findViewById(R.id.rv)

        val apiInterface = APIClient().getClient()?.create(FeedAPI::class.java)
        apiInterface!!.getFeed().enqueue(object : Callback<Feed> {
            override fun onResponse(call: Call<Feed>, response: Response<Feed>) {
               var updaterv = response.body()!!.entrys
                rv.adapter = RVAdap(updaterv)
                rv.layoutManager = LinearLayoutManager(applicationContext)
            }
            override fun onFailure(call: Call<Feed>, t: Throwable) {
                call.cancel()
            }
        })
    }

}



