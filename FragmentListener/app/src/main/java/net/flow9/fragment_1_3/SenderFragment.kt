package net.flow9.fragment_1_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import net.flow9.fragment_1_3.databinding.FragmentSenderBinding

class SenderFragment : Fragment() {

    lateinit var binding:FragmentSenderBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSenderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnYes.setOnClickListener {
            /*
                bundleOf("key" to "value") 로 쉽게 bundle 객체를 만들 수 있음
                bundle 에는 valueKey 라는 인식표(키)에 데이터 DataInBundle1 가 담겨있음
                setFragmentResult("requestKey", bundle) : 데이터를 보내는 프래그먼트에서 사용
            */
            val bundle = bundleOf("valueKey" to "DataInBundle1")
            setFragmentResult("request", bundle)
        }

        binding.btnNo.setOnClickListener {
            val bundle = bundleOf("valueKey" to "DataInBundle2")
            setFragmentResult("request", bundle)
        }
    }
}