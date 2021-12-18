package net.flow9.viewpager2_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import net.flow9.viewpager2_view.databinding.ActivityMainBinding

//뷰를 사용한 뷰페이저
class MainActivity : AppCompatActivity() {
    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //[START 뷰페이저 세팅_뷰]
        val textList = listOf("뷰A", "뷰B", "뷰C", "뷰D")
        val customAdapter = CustomPagerAdapter()
        customAdapter.textList = textList
        binding.viewPager.adapter = customAdapter
        //[END 뷰페이저 세팅_뷰]

        //[START 탭레아아웃 세팅]
        val tabTitles = listOf("View A", "View B", "View C", "View D")
        TabLayoutMediator(binding.tabLayout, binding.viewPager) {tab, position ->
            tab.text = tabTitles[position]
        }.attach()
        //[END 탭레아아웃 세팅]
    }
}

