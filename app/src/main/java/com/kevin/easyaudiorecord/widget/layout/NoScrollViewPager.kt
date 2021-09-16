package com.kevin.easyaudiorecord.widget.layout

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager
import kotlin.math.abs

/**
 *    @author : 王康
 *    @date   : 2021/9/13
 *    @desc   : 禁用水平滑动的ViewPager
 */
class NoScrollViewPager @JvmOverloads constructor(
    context: Context, attributeSet: AttributeSet? = null
) :
    ViewPager(context, attributeSet) {

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        //  不拦截触摸事件
        return false
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        //  不处理任何事件
        return false
    }

    override fun executeKeyEvent(event: KeyEvent): Boolean {
        //  不执行按钮事件
        return false
    }


    override fun setCurrentItem(item: Int) {
        //  只有相邻页面会有动画
        super.setCurrentItem(item, abs(currentItem - item) == 1)
    }


}