package net.flow9.fragment_1_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import net.flow9.fragment_1_3.databinding.FragmentReceiverBinding

/*Fragment Listener
setFragmentResultListener() : 데이터를 보내는 프래그먼트에서 사용
데이터를 보내는 프래그먼트에서 requestKey 로 값을 보내면 리스너 내부 코드 동작
리스너는 값을 수신하면 key, bundle 2개의 파라미터를 사용할 수 있는데, 데이터는 bundle 내부에 Map 형태로 담겨 있음
bundle.getString('키')로 값을 꺼냄

requestKey : 요청 전체에 대한 키 setFragmentResultListener("request")
key : 요청에 담겨 있는 여러 개의 값 중에 하나의 값을 가리키는 키 bundle.getString("valueKey")?.let
*/
class ReceiverFragment : Fragment() {
    lateinit var binding:FragmentReceiverBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentReceiverBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener("request") { key, bundle ->
            //let 은 스코프 함수로 bundle.getString("valueKey") 가 null 이 아닐 때 내부 코드를 동작 시킴
            bundle.getString("valueKey")?.let {
                binding.textView.setText(it)
            }
        }
    }
}

