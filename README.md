[![](https://jitpack.io/v/Mr-Bravestone/Android-Native-GPIO.svg)](https://jitpack.io/#Mr-Bravestone/Android-Native-GPIO)
# Android-Native-PWM
Credit: Me


<img src ="https://github.com/Mr-Bravestone/Android-Native-PWM/blob/master/art/pwm_anim.gif" height = 150 alt ="Android-Native-SerialPort"/>




# Device Must Be Rooted

# Usage
1. Add it in your root build.gradle/build.gradle.kts at the end of repositories:
```
	dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	}
```
2. To add a dependency to your project, specify a dependency configuration such as implementation in the dependencies block of your module's build.gradle file.
```
dependencies {
    //For Java.
    implementation 'com.github.Mr-Bravestone:Android-Native-GPIO:V1.0.1'
    //For Kotlin.
    implementation("com.github.Mr-Bravestone:Android-Native-GPIO:V1.0.1")
}
```
## 1. Check Root Ability
```
if (RootCheck().Ability())
{
	Toast.makeText(applicationContext,"Rooted",Toast.LENGTH_SHORT).show()
	//CONTINUE
}
else
{
	Toast.makeText(applicationContext,"Root Access Not Available",Toast.LENGTH_SHORT).show()
	//STOP ROOT NOT FOUND
}
```
## 2. Detect PWM Expander
```
if(PCA9685().getDeviceStatus())
{
	//Continue
}
else
{
	//Stop
}
```
## 3. Export PWM Pin
```
PCA9685().Export(pin) 
```
## 5. Set Period
```
PCA9685().Period(pin,1000000) // for example 1000000 nanoseconds
```
## 6. Set DutyCycle
```
PCA9685().DutyCycle(pin,500000) 
```
# 7. Set Enable 
```
PCA9685().Enable(pin,1) // for Enable 
PCA9685().Enable(pin,0) // for Disable
```
