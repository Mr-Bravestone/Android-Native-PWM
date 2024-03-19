[![](https://jitpack.io/v/Mr-Bravestone/Android-Native-GPIO.svg)](https://jitpack.io/#Mr-Bravestone/Android-Native-GPIO)
# Android-Native-GPIO
Credit: Me


<img src ="https://github.com/Mr-Bravestone/Android-Native-GPIO/blob/master/art/Start.png" height = 150 alt ="Android-Native-SerialPort"/> <img src ="https://github.com/Mr-Bravestone/Android-Native-GPIO/blob/master/art/ListGpio.png" height = 150 alt ="Android-Native-SerialPort"/> <img src ="https://github.com/Mr-Bravestone/Android-Native-GPIO/blob/master/art/GpioControlOn.png" height = 150 alt ="Android-Native-SerialPort"/> <img src ="https://github.com/Mr-Bravestone/Android-Native-GPIO/blob/master/art/GpioControlOff.png" height = 150 alt ="Android-Native-SerialPort"/>



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
## 2. Detect Gpio Expander
```
if(PCF8575().getDeviceStatus().equals("DeviceAvailable"))
{
	//Continue
}
else
{
	//Stop
}
```
## 3. Get Gpio Pins Range
```
val gpio = PCF8575().getGPIOs() //gpio range for like 1264-1279 on my 16bit PCF8575 Expander
println(gpio)
```
## 4. Export Gpio
```
IO().Export(pin) //pin = gpio number like 1264 Int Value
```
## 5. Set Direction
```
IO().Direction(pin,"out") // for output
IO().Direction(pin,"in") // for input
```
## 6. Set Gpio Value
```
IO().Write(pin,1) // for high like arduino digitalWrite
IO().Write(pin,0) // for low like arduino digitalWrite
```
# 7. Read Gpio Value
```
IO().GetValue(pin) // Read Value from Gpio pin like arduino digitalRead  -  it returns 0 / 1
```
