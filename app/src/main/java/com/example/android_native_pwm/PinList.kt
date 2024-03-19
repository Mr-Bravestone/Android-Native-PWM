package com.example.android_native_pwm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import mr.bravestone.android_pwm.PCA9685

class PinList : AppCompatActivity() {
    var Start = 0
    var Stop = 15
    var initval:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pin_list)

        for (i in Start!!..Stop!!)
        {
            addBtn(i)
            PCA9685().Export(i)
        }
    }
    fun addBtn(i:Int){
        val layout = findViewById(R.id.layout) as LinearLayout
        val button = Button(this)
        button.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        button.text = "PIN - "  + initval + "  ~~  PWM"+ i
        button.id = i
        button.setOnClickListener {
            var btnid = button.id
            var btntxt = button.text
            val intent = Intent(this, PinControl::class.java)
            intent.putExtra("id",btnid)
            intent.putExtra("text",btntxt)
            startActivity(intent)
            Toast.makeText(this, button.id.toString(), Toast.LENGTH_LONG).show()
        }
        layout.addView(button)
        initval++
    }
}