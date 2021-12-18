package com.example.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragment.databinding.FragmentListBinding

class ListFragment : Fragment() {
    var mainActivity:MainActivity? = null
    lateinit var binding:FragmentListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        //MainActivity 에 있는 setFragment() 메서드에서 Bundle() 에 담겨 넘어온 value 를 key 로 받음
        binding.textTitle.text = arguments?.getString("key1")
        binding.textValue.text = "${arguments?.getInt("key2")}"
        binding.btnNext.setOnClickListener {
            mainActivity?.goDetailFragment()
        }
        //프래그먼트의 onCreateView() 메서드 반환값이 View 이기 때문에 return binding 이 아니라 return binding.root 로 'root 뷰' 를 반환해야함
        return binding.root
    }

    /*onAttach() 메서드를 통해서 넘어온 context 는 부모 액티비티(MainActivity) 전체가 담겨 있음
      안정성을 위해 넘어온 context 를 MainActivity 로 한번 캐스팅해줌*/
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }

    // setValue() 가 액티비티에서 사용되지만 프래그먼트에서 정의한 이유는 데이터를 출력할 목표 UI 가 프래그먼트이기 떄문. binding.textFromActivity.text
    fun setValue(value:String) {
        binding.textFromActivity.text = value
    }

}
