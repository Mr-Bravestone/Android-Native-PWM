package mr.bravestone.android_pwm

class RootCheck {
    fun Ability(): Boolean {
        try{
            var result = ShellExec("su -c ls").Status
            if(result == "pass")
            {
                println("Rooted")
                return true
            }
            else
            {
                println("RootNotFound")
                return false
            }

        }catch(e: Exception){
            println("RootNotFound")
            return false
        }

    }
}