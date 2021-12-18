package com.june.customwidget

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
/*
  커스템 위젯 : 회사 내부에서 기본 위젯을 상속 받아 앞에 접두어를 붙혀 커스텀 위젯으로 사용 ex) KakaoTextView
  CustomWidget : yyyyMMdd 로 된 값을 입력하면 yyyy-MM-dd 로 연월일 사이에 자동으로 - 를 넣어주는 위젯

  3가지 단계를 거침
  1) attr.xml 파일 생성 (커스텀 위젯의 속성 정보가 담겨있음)
     [res] - [values] - attr.xml
     레이아웃 파일에서 태그 속성의 접두사가 android 가 아닌 userCustom 으로 정의된 새로운 속성 값을 사용할 수 있음
  2) CustomWidget 클래스 생성
     커스텀을 하기 위한 위젯 클래스를 상속받아 클래스를 생성하고 1) 에서 새롭게 정의한 속성을 처리하는 코드 작성
     * 버전 호환성을 위해 기본 위젯 TextView 가 아니라 AppCompatTextView 를 상속받는다.
     * 항상 생성자 3개를 모두 작성해 두는 것이 좋음 //우클릭 -> Generate -> Secondary Constructor

  3) 레이아웃에 태그 적용
     palette 에 project 가 생성되는 데 거기에 생성한 CustomWidget 이 있음
     * project 가 보이지 않을 때는 안드로이드 스튜디오를 재시작함
*/

class CustomWidget: AppCompatTextView {
    //위젯 클래스를 소스 코드에서 사용할 때 호출됨
    constructor(context: Context): super(context){
    }

    //레이아웃 파일에서 위젯 클래스를 사용할 때 호출 됨
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs){
        //res/values/attrCustomWidget 정의된 attr 가져옴
        val typed = context.obtainStyledAttributes(attrs, R.styleable.CustomWidget)
        val size = typed.indexCount

        for (i in 0 until size) {
            /*
              typed.getIndex(i) 으로 현재 속성을 확인하고 CustomWidget_delimiter 와 같다면
              XML 에 입력된 delimiter 값을 꺼내고
              꺼낸 값을 process() 메서드에 넘겨서 처리
            */
            when (typed.getIndex(i)) {
                R.styleable.CustomWidget_delimiter -> {
                    val delimiter = typed.getString(typed.getIndex(i)) ?: "-"
                    process(delimiter)
                }
            }
        }
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
    }

    fun process(delimiter: String){
        //20211127
        var one = text.substring(0,4) //2021
        var two = text.substring(4,6) //11
        var three = text.substring(6) //27

        setText("$one $delimiter $two $delimiter $three")
    }
}