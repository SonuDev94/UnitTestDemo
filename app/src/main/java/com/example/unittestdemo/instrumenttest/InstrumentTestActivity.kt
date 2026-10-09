/**
 * @Author: Created by Sonu Kumar
 * @Date: 22/01/25 1:46 PM.
 * @Email: sonu02@countrydelight.in
 */

package com.example.unittestdemo.instrumenttest

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.unittestdemo.databinding.ActivityIntrumentTestBinding


/**
 * Class Definition
 *
 */
class InstrumentTestActivity : AppCompatActivity() {
    lateinit var binding: ActivityIntrumentTestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntrumentTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.changeTextBt.setOnClickListener {
            binding.textToBeChanged.text = binding.editTextUserInput.text.toString()
        }

        binding.activityChangeTextBtn.setOnClickListener {
            val msg = binding.editTextUserInput.text.toString()
            startActivity(ShowTextActivity.newInstance(this, msg))
        }

        binding.shareBtn.setOnClickListener {
            val sendIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "Hello I am Android Developer")
            }
            val shareIntent = Intent.createChooser(sendIntent, "Share via")
            startActivity(shareIntent)
        }
    }
}