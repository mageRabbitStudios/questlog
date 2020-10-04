package com.kinzlstanislav.questlog.base.view

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.drawable.VectorDrawable
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.core.view.doOnPreDraw
import androidx.core.view.forEach
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kinzlstanislav.questlog.R
import com.kinzlstanislav.questlog.base.ktx.dp

class BottomNavigationViewWithIndicator @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BottomNavigationView(context, attrs, defStyleAttr) {

    private lateinit var indicator: AppCompatImageView
    private val indicatorXPositions = mutableListOf<Float>()

    init {
        if (::indicator.isInitialized) removeView(indicator)
        indicator = AppCompatImageView(context).apply {
            setImageDrawable(
                ContextCompat.getDrawable(
                    context,
                    R.drawable.ic_navigation_selected_item_dot
                ) as VectorDrawable
            )
            layoutParams = ViewGroup.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT
            )
        }

        var indicatorY = 0
        var initialIndicatorPositionSet = false

        (getChildAt(0) as ViewGroup).forEach { menuItem ->
            doOnPreDraw {
                if (indicatorY == 0) {
                    indicatorY = menuItem.measuredHeight + 8.dp
                }
                val middleX = (menuItem.x + (menuItem.measuredWidth / 2)) - 2.dp
                indicatorXPositions.add(middleX)

                if (!initialIndicatorPositionSet) {
                    indicator.apply {
                        x = indicatorXPositions[0]
                        y = indicatorY.toFloat()
                    }
                    addView(indicator)
                    initialIndicatorPositionSet = true
                }
            }
        }
    }

    fun moveIndicator(toPosition: Int) {
        if (toPosition >= indicatorXPositions.size || !::indicator.isInitialized) {
            return
        }

        val animDur = resources.getInteger(android.R.integer.config_mediumAnimTime).toLong()
        val translationXAnim = ObjectAnimator.ofFloat(
            indicator,
            "translationX",
            indicatorXPositions[toPosition]
        ).apply {
            duration = animDur
        }
        val stretchAnim = ObjectAnimator.ofFloat(indicator, "scaleX", 3f).apply {
            duration = animDur / 2
        }
        val normaliseAnim = ObjectAnimator.ofFloat(indicator, "scaleX", 1f).apply {
            duration = animDur / 2
        }
        AnimatorSet().apply {
            play(translationXAnim).with(stretchAnim)
            play(normaliseAnim).after(stretchAnim)
            start()
        }
    }
}