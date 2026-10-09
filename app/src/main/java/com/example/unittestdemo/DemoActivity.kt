/**
 * @Author: Created by Sonu Kumar
 * @Date: 20/12/24 10:41 AM.
 * @Email: sonu02@countrydelight.in
 */

package com.example.unittestdemo

import android.graphics.drawable.Animatable2
import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.vectordrawable.graphics.drawable.Animatable2Compat
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.example.unittestdemo.databinding.ActivityDemoBinding
import com.example.unittestdemo.ui.theme.GreenLineView
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


/**
 * Class Definition
 *
 */
class DemoActivity : AppCompatActivity() {
    lateinit var binding : ActivityDemoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvSearch.setOnClickListener{
            test()
            animateDelivery()
        }
    }





    fun animateDelivery(){
        binding.clOrderStatusView.visibility =
            View.VISIBLE
        val deliveryProgress = 0.1f
        val deliveryStage = 4
        binding.imgBike.post {
            val totalWidth = binding.dashedLine.width.toFloat()
                .minus(binding.imgBike.layoutParams.width)
            val translationDistance =
                totalWidth * (deliveryProgress ?: 0.0f)
            // Animate the bike
            binding.imgBike.animate()
                .setDuration(3000)
                .translationX(translationDistance)
                .start()

            // Animate the green line's scaleX
            // val startX = holder.itemView.imgOrderProcessed.x + holder.itemView.imgOrderProcessed.width
            binding.dashedLineGreen.visibility = View.VISIBLE
            GreenLineView.animateLine(
                binding.dashedLineGreen,
                0f,
                translationDistance
            )
            if (deliveryStage == 5) {
                binding.clOrderStatusView.animate().alpha(0f)
                    .setStartDelay(3000).setDuration(2000)
                    .withEndAction {
                        binding.clOrderStatusView.visibility =
                            View.GONE
                    }.start()
            }

        }
    }



    private fun test() {
        val sonuView = findViewById<TextView>(R.id.sonuView)
//        val clView = findViewById<ConstraintLayout>(R.id.searchBar)
//        sonuView.setBackgroundResource(R.drawable.test2)

        // Get the background drawable
        val background: Drawable = sonuView.background
//        if(background is AnimatedVectorDrawable) background.start()

        // Animate the background
        when (background) {
            is AnimatedVectorDrawableCompat -> {
                background.start()
                background.registerAnimationCallback(object : Animatable2Compat.AnimationCallback() {
                    override fun onAnimationEnd(drawable: Drawable?) {
                        Log.d("Test","end")
                    }

                    override fun onAnimationStart(drawable: Drawable?) {
                        super.onAnimationStart(drawable)
                        Log.d("Test","Start")
                    }
                })
            }
            is AnimatedVectorDrawable -> {
                background.start()
                background.registerAnimationCallback(object : Animatable2.AnimationCallback() {
                    override fun onAnimationEnd(drawable: Drawable?) {
                        Log.d("Test","ENd")
                        lifecycleScope.launch {
                            delay(1000)
                            background.start()
                        }

                    }

                    override fun onAnimationStart(drawable: Drawable?) {
                        super.onAnimationStart(drawable)
                        Log.d("Test","Start")
                    }
                })
            }
        }

    }
}