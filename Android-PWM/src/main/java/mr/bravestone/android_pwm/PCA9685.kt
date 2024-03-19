package mr.bravestone.android_pwm

import android.util.Log

class PCA9685 {
    private var DeviceStatus = ""
    private fun CheckDevice() {
        var result=ShellExec("su -c cat /sys/kernel/debug/pwm | grep 17").Result
        var resultSplitWith :List<String> = result.split(":",",").map { it.trim() }
        if (result.isBlank())
        {
            DeviceStatus = "NoDevice"
        }
        else if (result.isNotBlank()){
            DeviceStatus = "DeviceAvailable"
        }

    }

    fun getDeviceStatus(): Boolean {
        CheckDevice()
        if (DeviceStatus == "NoDevice"){
            return false
        }
        else {
            return true
        }
    }

    fun Export(pin:Int): String {
        return ShellExec("su -c echo $pin  > /sys/class/pwm/pwmchip1/export").Status
    }
    fun Enable(pin:Int,en:Int): String {
        return ShellExec("su -c echo $en  > /sys/class/pwm/pwmchip1/pwm$pin/enable").Status
    }
    fun DutyCycle(pin:Int,duty:Int): String {
        return ShellExec("su -c echo $duty  > /sys/class/pwm/pwmchip1/pwm$pin/duty_cycle").Status
    }
    fun Period(pin:Int,period:Int): String {
        return ShellExec("su -c echo $period  > /sys/class/pwm/pwmchip1/pwm$pin/period").Status
    }
    fun Frequency(pin:Int,freq_hz:Int): String {
        var Ts:Float = 1 / freq_hz.toFloat()
        var Tns:Float = Ts * 1000000000
        Log.d("RZA",Tns.toString())
        return ShellExec("su -c echo $Tns  > /sys/class/pwm/pwmchip1/pwm$pin/period").Status
        return ""
    }
    fun OutputType(pin:Int,fixed:Int): String {
        return ShellExec("su -c echo $fixed  > /sys/class/pwm/pwmchip1/pwm$pin/output_type").Status
    }

    fun ReadDuty(pin:Int): String {
        return ShellExec("su -c cat /sys/class/pwm/pwmchip1/pwm$pin/duty_cycle").Result
    }
    fun ReadPeriod(pin:Int): String {
        return ShellExec("su -c cat /sys/class/pwm/pwmchip1/pwm$pin/period").Result
    }
    fun ReadEnable(pin:Int): String {
        return ShellExec("su -c cat /sys/class/pwm/pwmchip1/pwm$pin/enable").Result
    }


}