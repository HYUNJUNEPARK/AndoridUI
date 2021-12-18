package net.flow9.viewpager

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.google.android.material.tabs.TabLayoutMediator
import net.flow9.viewpager.databinding.ActivityMainBinding
import net.flow9.viewpager.fragment.FragmentA
import net.flow9.viewpager.fragment.FragmentB
import net.flow9.viewpager.fragment.FragmentC
import net.flow9.viewpager.fragment.FragmentD

/*프래그먼트를 사용한 뷰페이저
  프래그먼트 : 화면들이 독립적으로 구성될 필요가 있을 때 사용
  뷰 : 리사이클러뷰에서 하나의 아이템 레이아웃을 사용해서 반복적으로 동일한 구조의 텍스트나 이미지를 보여줄 때 사용
  사진 갤러리 앱이 동작하는 것 처럼 목록을 가로로 스와이프해서 보여줄 필요가 있을 때 사용(ContainerViewPagerTabLayout_View 참조)

  뷰페이저 : 스와이프로 화면을 전환할 수 있도록 제공되는 컨테이너. 한 화면에 하나의 아이템만 보이는 리사이클러뷰 개념과 유사
  페이저어댑터 : 뷰페이저에서 보일 화면들을 연결하는 구조
  탭레이아웃 : 탭 메뉴 구성을 위한 레이아웃

  뷰페이저 생성
  Palette -> Containers -> ViewPager2 로 컨테이너 추가
  안드로이드 스튜디오 4 버전부터 ViewPager 에서 ViewPager2 로 변경됨
  ViewPager2 에서는 TabLayoutMediator 로 탭레이아웃과 뷰페이저를 연결할 수 있음

  탭레이아웃 생성
  Palette -> Containers -> TabLayout 으로 컨테이너 추가*/

class MainActivity : FragmentActivity() {
    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //[START 뷰페이저 세팅_프래그먼트]
        val fragmentList = listOf(FragmentA(), FragmentB(), FragmentC(), FragmentD())
        val adapter = FragmentAdapter(this)
        adapter.fragmentList = fragmentList
        binding.viewPager.adapter = adapter
        //[END 뷰페이저 세팅]

        //[START 탭 레이아웃 세팅]
        val tabTitles = listOf<String>("A", "B", "C", "D")
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
        //[END 탭 레이아웃 세팅]
    }
}