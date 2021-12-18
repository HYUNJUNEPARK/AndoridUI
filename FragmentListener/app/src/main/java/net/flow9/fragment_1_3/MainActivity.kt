package net.flow9.fragment_1_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/*
   Fragment Listener
   프래그먼트 간 통신을 위해 fragment 버전 1.3.x 부터 제공되는 기능
   앱 수준 build.gradle 에서 dependency 추가
   https://developer.android.com/jetpack/androidx/releases/fragment#kts 에서 최신 버전 확인할 수 있음
   프래그먼트에 onViewCreated() 를 오버라이드한 후 블럭 내부에 코드 작성

   setFragmentResult("requestKey", bundle) : 데이터를 보내는 프래그먼트에서 사용
   setFragmentResultListener("requestKey") : 데이터를 받는 프래그먼트에서 사용
*/

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}