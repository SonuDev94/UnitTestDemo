/*
 * Copyright 2015, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.unittestdemo.instrumenttest;

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.unittestdemo.databinding.ActivityShowTextBinding

/**
 * A simple {@link Activity} that shows a message.
 */
val KEY_EXTRA_MESSAGE =
    "com.example.android.testing.espresso.basicsample.MESSAGE";

 class ShowTextActivity : AppCompatActivity() {
    lateinit var binding: ActivityShowTextBinding

    // The name of the extra data sent through an {@link Intent}.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowTextBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val message = intent.getStringExtra(KEY_EXTRA_MESSAGE)
        binding.showTextView.text = message
    }

    /**
     * Creates an {@link Intent} for {@link ShowTextActivity} with the message to be displayed.
     * @param context the {@link Context} where the {@link Intent} will be used
     * @param message a {@link String} with text to be displayed
     * @return an {@link Intent} used to start {@link ShowTextActivity}
     */

    companion object {
        fun newInstance(context: Context, message: String): Intent {
            val intent = Intent(context, ShowTextActivity::class.java)
            intent.putExtra(KEY_EXTRA_MESSAGE, message)
            return intent
        }
    }
}
