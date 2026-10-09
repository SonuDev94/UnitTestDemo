/**
 * @Author: Created by Prashant Kumar
 * @Date: 17/09/24 2:49 pm.
 * @Email: prashantchaudary@countrydelight.in
 */

package com.example.unittestdemo.ui.theme

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.example.unittestdemo.R


/**
 * Class Definition
 *
 */
class GreenLineView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = ContextCompat.getColor(context, R.color.purple_500)
        strokeWidth = 5f
    }

    var endX = 0f

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawLine(0f, height / 2f, endX, height / 2f, paint)
    }

    companion object {
        fun animateLine(view: GreenLineView, startX: Float, targetEndX: Float) {
            ValueAnimator.ofFloat(startX, targetEndX).apply {
                duration = 3000
                addUpdateListener { valueAnimator ->
                    view.endX = valueAnimator.animatedValue as Float
                    view.invalidate()
                }
                start()
            }
        }
    }
}