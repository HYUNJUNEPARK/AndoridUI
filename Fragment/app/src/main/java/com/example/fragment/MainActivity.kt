package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragment.databinding.ActivityMainBinding

/*프래그먼트 생성 [New]-[Fragment]-[Fragment(Blank)]
  안드로이드 스튜디오 4.2 이후 버전부터는 앱 수준 build.gradle 파일의 minSdkVersion 설정이 최소 16이 되지않는다면 이 방법으로 프래그먼트 생성 불가

  activity_main.xml 에 'FrameLayout' 을 사용
  a. Common - <fragment> : 화면 전환 없이 프래그먼트 하나만 화면에 표시 할 때
  b. Layouts - FrameLayout : 화면 전환이 필요할 때
  액티비티에 DetailFragment, ListFragment 두 프래그먼트를 연결한 후 ListFragment -> DetailFragment 화면 전환이 일어나기 떄문에 FrameLayout 을 사용함

  프래그먼트는 하나의 레이아웃에 한 층씩 쌓이는 형태라 기본 배경색을 성정하지 않으면 화면이 중첩됨
  쌓여진 프래그먼트들의 버튼이 중첩되어있다면 동시에 두개가 눌릴 수 있음 -> 최상단 레이아웃(ConstraintLayout) 속성에 android:clickable="true" 를 줌*/

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    lateinit var listFragment:ListFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setFragment()
        // setValue() 가 액티비티에서 사용되지만 프래그먼트에서 정의한 이유는 데이터를 출력할 목표 UI 가 프래그먼트이기 떄문. binding.textFromActivity.text
        binding.btnSend.setOnClickListener {
            listFragment.setValue("SENT VALUE")
        }
    }


    fun setFragment() {
        listFragment = ListFragment()

        //[START Bundle()로 데이터 전달 To ListFragment]
        // arguments : 프레그먼트의 기본 프로퍼티로 Bundle() 객체를 전달하면 생성된 프래그먼트에서 argument 를 꺼낼 수 있음
        var bundle = Bundle()
        bundle.putString("key1", "리스트 프래그먼트")
        bundle.putInt("key2", 1234)
        listFragment.arguments = bundle
        //[END  Bundle()로 데이터 전달]


        //[START Setting Transaction]
        /*트랜잭션 : 서로 연관되어 있는 작업을 할 때 중간에 하나라도 잘못되면 모든 동작을 복구하는 하나의 작업 단위
          beginTransaction -> add fragment -> commit transaction 순으로 처리됨
          supportFragmentManager : 액티비티가 갖고 있는 프래그먼트 매니저
          add(액티비티에서 프래그먼트가 삽입될 레이아웃 id, 삽입할 프래그먼트)*/
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayoutInMainActivity, listFragment)
        transaction.commit()
        //[END Setting Transaction]
    }


    //[START ListFragment, DetailFragment 에서 쓰인 메서드]
    /*프래그먼트에서 쓰이는 메서드지만 액티비티에서 만드는 것을 권장함
      구현한 기능은 프래그먼트 간 이동하는 기능으로, 액티비티의 FragmentLayout 내부에서 작동하도록 만든 것이기 때문
      만약 구현한 기능이 프래그먼트 내부에서만 쓰인다면 프래그먼트에 만듬*/
    fun goDetailFragment(){
        val detailFragment = DetailFragment()

        //[START Setting Transaction]
        /*addToBackStack : 프래그먼트를 백스택 형태로 메모리에 담아둘 수 있는 기능
          add 와 commit 사이에 addToBackStack()를 추가하면 스마트폰의 뒤로가기 버튼을 사용할 수 있음
          addToBackStack()를 사용하지 않은 채로 뒤로가기 버튼을 누르면 액티비티가 종료됨*/
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayoutInMainActivity, detailFragment)
        transaction.addToBackStack("detail")
        transaction.commit()
        //[END Setting Transaction]
    }

    fun goBackFromDetailFragment(){
        //onBackPressed() : 뒤로가기가 필요할 때 사용하는 액티비티 기본 메서드
        onBackPressed()
    }
    //[START 프래그먼트에서 쓰이는 메서드]
}
