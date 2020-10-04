package com.kinzlstanislav.questlog.base.view

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import com.daimajia.swipe.SwipeLayout

class ModifiedSwipeLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : SwipeLayout(context, attrs, defStyleAttr) {

    override fun onInterceptTouchEvent(ev: MotionEvent) = if (ev.rawX > surfaceView.x + surfaceView.width)
        false else super.onInterceptTouchEvent(ev)
}