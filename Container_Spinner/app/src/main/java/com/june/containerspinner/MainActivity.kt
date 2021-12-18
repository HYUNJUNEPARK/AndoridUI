package com.june.containerspinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.june.containerspinner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var dataForSpinner = listOf("-Sample-", "A", "B", "C")

        //[START Setting Adapter For Spinner]
        /*
          ArrayAdapter : dataForSpinner 와 스피너를 연결해주는 클래스. adapter 에서 사용할 데이터 타입을 제네릭으로 지정
          ArrayAdapter<dataType>(context, android.R.layout.simple_list_item_1, data)
          android.R.layout.simple_list_item_1 : 스피너에 보여줄 목룍 하나하나가 그려질 레이아웃으로 텍스트뷰 1개만 갖고 있음.
         */
        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataForSpinner)
        binding.spinner.adapter = adapter
        //[END Setting Adapter For Spinner]


        //onItemSelectedListener : 스피너의 동작을 인식해 사용자가 스피너를 선택하면 선택한 값을 선택 결과에 보여줌
        //스피너의 동작으로 선택된 값의 인덱스를 갖고 위에서 만들어 둔 dataForSpinner 의 인덱스의 값을 꺼내옴
        binding.spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                if(position != 0){
                    binding.result.text = dataForSpinner.get(position)
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }
}