package com.june.containerrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.containerrecyclerview.AdapterForRecyclerView
import com.june.containerrecyclerview.data.SampleData
import com.june.containerrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //[START 가상 데이터 생성 후 리사이클러뷰 어댑터에 전달]
        val data:MutableList<SampleData> = loadData()
        var adapter = AdapterForRecyclerView()
        adapter.listData = data
        //[END 가상 데이터 생성 후 리사이클러뷰 어댑터에 전달]


        //[START 리사이클러뷰 어댑터와 레이아웃 매니저 세팅]
        /*
          LinearLayoutManager
          GridLayoutManager
          StaggeredGridLayoutManager
        */
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        //[END 리사이클러뷰 어댑터와 레이아웃 매니저 세팅]
    }

    //데이터 클래스 SampleData 의 형식에 맞게 생성한 가상 데이터를 넣어줌
    fun loadData() : MutableList<SampleData> {
        val data:MutableList<SampleData> = mutableListOf()
        for(number in 1..100){
            val title = "Sample ${number}"
            val date = System.currentTimeMillis()
            var memo = SampleData(number, title, date)
            data.add(memo)
        }
        return data;
    }
}