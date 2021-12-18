package net.flow9.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

/*프래그먼트 어댑터
  FragmentStateAdapter() 를 상속받아 클래스를 생성
  getItemCount(), createFragment(position: Int) 오버라이딩*/

class FragmentAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    var fragmentList = listOf<Fragment>()

    //어댑터가 화면에 보여줄 전체 프래그먼트의 개수를 반환
    override fun getItemCount(): Int {
        return fragmentList.size
    }

    //현재 페이지의 position 이 파라미터로 넘어옴. position 에 해당하는 위치의 프래그먼트를 만들어서 안드로이드에 반환해줘야함
    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}


