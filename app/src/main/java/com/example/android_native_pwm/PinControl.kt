package com.example.android_native_pwm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.Switch
import android.widget.TextView
import mr.bravestone.android_pwm.PCA9685
import java.time.Period

class PinControl : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pin_control)

        var id = intent.extras?.getInt("id")
        var text = intent.extras?.getString("text")
        val Info = findViewById<TextView>(R.id.info)
        Info.text= text

        val ValSwitch = findViewById<Switch>(R.id.ValSwitch)
        val DutySeek = findViewById<SeekBar>(R.id.dutySeek)
        val PeriodSeek = findViewById<SeekBar>(R.id.periodSeek)
        val PeriodTv = findViewById<TextView>(R.id.periodTv)
        val DutyTv = findViewById<TextView>(R.id.dutyTv)

        var DutyVal = PCA9685().ReadDuty(id!!).toDouble().toInt()
        var PeriodVal = PCA9685().ReadPeriod(id).toDouble().toInt()
        var EnableVal = PCA9685().ReadEnable(id).toDouble().toInt()
        println(DutyVal)
        println(PeriodVal)
        println(EnableVal)


        if(DutyVal >= 0 && DutyVal <= 1000000)
        {
            DutyTv.text = DutyVal.toString()
            DutySeek.progress = DutyVal
        }
        if (PeriodVal >= 600000 && PeriodVal <= 1000000)
        {
            PeriodTv.text = PeriodVal.toString()
            PeriodSeek.progress = PeriodVal
        }
        if (EnableVal == 1)
        {
            ValSwitch.setChecked(true);
        }
        else
        {
            ValSwitch.setChecked(false);
        }


        DutySeek?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                DutyTv.text = DutySeek.progress.toString()
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                PCA9685().DutyCycle(id!!,DutySeek.progress)
            }
        })

        PeriodSeek?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                PeriodTv.text = PeriodSeek.progress.toString()
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                PCA9685().Period(id!!,PeriodSeek.progress)
            }
        })

        ValSwitch?.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked)
            {
                PCA9685().Enable(id!!,1)
            }
            else
            {
                PCA9685().Enable(id!!,0)
            }
        }




    }

}