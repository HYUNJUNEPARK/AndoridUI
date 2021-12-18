package com.example.customview

import android.content.Context
import android.graphics.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.customview.databinding.ActivityMainBinding

/*
  0. onDraw(canvas: Canvas?)
  오버라이딩해서 사용하며 내부에 코드를 작성해 UI 에 도형을 그림

  1. Canvas 클래스
  Canvas 는 그리기 도구로 그림판과 함께 그림을 그리기 위해 draw 로 시작하는 메서드가 제공됨
  ex) drawText, drawCircle, drawRect, drawRoundRect 등
  drawText(text, x좌표, y좌표, 색상 정보)
  drawText 를 할 때 좌표의 기준이 문자열의 좌측 하단이기 때문에 y 좌표 속성이 없다면 텍스트의 아래 부분만 짤려서 나옴

  2. Paint() 속성
  글자색, 두께 정보 등 색상 정보
  testSize : 글자의 크기. drawText() 메서드일 경우만 사용
  strokeWidth : 외곽선을 그릴 경우 외곽선의 두께를 정의함
  style : 도형 형태, 외곽선 그리기, 면 채우기 등 모양 정의. 사용할 스타일이 클래스에 상수로 미리 정의되어 있음
  ex) paint.style = Paint.Style.STROKE
*/

class MainActivity : AppCompatActivity() {
    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val customView = CustomView("Sample Text",this)
        binding.frameLayout.addView(customView)
    }
}

// View 클래스를 상속받은 후에 onDraw() 메서드로 전달되는 Canvas 를 사용하면 원하는 그림을 그릴 수 있음
class CustomView(text:String, context: Context) : View(context) {
    val text:String
    init {
        this.text = text
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        //[START 텍스트 그리기]
        val paint = Paint()
        paint.color = Color.BLACK
        paint.textSize = 100f
        canvas?.drawText(text, 0f, 100f, paint)
        //[END 텍스트 그리기]

        drawFigure(canvas)
    }

    //[START drawFigure() : 뷰에 그림 그리기]
    //도형을 그리기 위해서는 onDraw() 내부에서 호출되어 canvas 를 파라미터로 받아야 함
    fun drawFigure(canvas: Canvas?) {
        // 원 그리기
        val paintBlue = Paint()
        paintBlue.style = Paint.Style.FILL
        paintBlue.color = Color.BLUE
        canvas?.drawCircle(150f,300f, 100f, paintBlue)

        // 원 외곽선 그리기
        val paintRed = Paint()
        paintRed.style = Paint.Style.STROKE
        paintRed.color = Color.RED
        canvas?.drawCircle(400f,300f, 100f, paintRed)

        // 사각형 그리기
        val paintGreen = Paint()
        paintGreen.style = Paint.Style.STROKE
        paintGreen.strokeWidth = 20f
        paintGreen.color = Color.GREEN
        val rect = Rect(50, 450, 250, 650)
        canvas?.drawRect(rect, paintGreen)

        // 라운드 진 사각형 그리기
        val paintCyan = Paint()
        paintCyan.style = Paint.Style.FILL
        paintCyan.color = Color.CYAN
        val rectF = RectF(300f, 450f, 500f, 650f)
        canvas?.drawRoundRect(rectF, 50f, 50f, paintCyan)
    }
    //[END drawFigure() : 뷰에 그림 그리기]
}