package com.example.android_native_pwm

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import mr.bravestone.android_pwm.PCA9685
import mr.bravestone.android_pwm.RootCheck

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                if (RootCheck().Ability())
                {
                    Toast.makeText(applicationContext,"Rooted",Toast.LENGTH_SHORT).show()
                    if(PCA9685().getDeviceStatus()){

                        startActivity(Intent(this@MainActivity,PinList::class.java))
                    }
                    else
                    {
                        Toast.makeText(applicationContext,"No PWM Expander Detected",Toast.LENGTH_SHORT).show()
                    }


                }
                else
                {
                    Toast.makeText(applicationContext,"Root Access Not Available",Toast.LENGTH_SHORT).show()
                }
            }
        })


    }


}