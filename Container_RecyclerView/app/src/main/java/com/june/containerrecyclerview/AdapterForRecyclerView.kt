package com.example.containerrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.june.containerrecyclerview.data.SampleData
import com.june.containerrecyclerview.databinding.ItemRecyclerBinding
import java.text.SimpleDateFormat

/*
  리사이클러뷰는 RecyclerView.Adapter<뷰홀더 클래스>() 를 상속받은 '리사이클러뷰 어댑터' 를 사용해 데이터를 연결함
  뷰홀더 클래스 : RecyclerView.ViewHolder() 를 상속받은 클래스로. 개별 데이터의 대응
  item_recycler.xml : 한 개의 뷰홀더가 담을 xml 파일
*/

class AdapterForRecyclerView : RecyclerView.Adapter<AdapterForRecyclerView.Holder>() {
    var listData = mutableListOf<SampleData>()

    //[START onCreateViewHolder]
    /*
       아이템 레이아웃 생성. 아이템 레이아웃을 바인딩한 후 '뷰홀더' 에 넘겨줌
       스마트폰 화면에 보이는 목록 갯수만큼 안드로이드 시스템이 이 메서드 호출.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }
    //[END onCreateViewHolder]


    //[START getItemCount]
    /*
      리사이클러뷰에서 사용할 데이터의 총 개수를 리턴
     */
    override fun getItemCount(): Int {
        return listData.size
    }
    //[END getItemCount]


    //[START onBindingViewHolder]
    /*
      생성된 뷰홀더를 화면에 '보여주는' 메서드
      화면에 보이는 아이템 레이아웃의 인덱스 데이터(position)를 갖고 있음
      인덱스 데이터 파라미터를 홀더 클래스 내부 함수로 전달할 수 있음
    */
    override fun onBindViewHolder(holder: Holder, position: Int) {
        val data = listData.get(position)
        holder.setData(data)
    }
    //[END onBindingViewHolder]


    //[START 뷰홀더 클래스]
    /*
      class Holder(바인딩) : RecyclerView.ViewHolder(바인딩.root)
      뷰홀더는 현재 화면에 보여지는 개수만큼만 생성되고 스크롤이 이동하면 화면에 보이지 않는 목록을 담은 홀더는 아래로 이동해 재사용 됨

      onBindViewHolder() 메서드로 부터 인덱스 파라미터를 받아 처리하는 메서드를 만들 수 있음
      목록에서 아이템 1개가 클릭 되었을 때 처리 방법 : 홀더가 갖고 있는 아이템 바인딩에 클릭리스너를 달아 처리
    */
    inner class Holder(val binding: ItemRecyclerBinding) : RecyclerView.ViewHolder(binding.root) {
        //홀더 클래스가 생성되는 시점에 클릭리스터를 추가
        init {
            binding.root.setOnClickListener {
                Toast.makeText(binding.root.context,"클릭된 아이템=${binding.textTitle.text}", Toast.LENGTH_LONG).show()
            }
        }
        fun setData(data: SampleData) {
            binding.textNo.text = "${data.no}"
            binding.textTitle.text = data.title
            var sdf = SimpleDateFormat("yyyy/MM/dd")
            var formattedDate = sdf.format(data.timestamp)
            binding.textDate.text = formattedDate
        }
    }
    //[END 뷰홀더 클래스]
}


