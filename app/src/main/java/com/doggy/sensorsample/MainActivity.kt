package com.doggy.sensorsample

import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.doggy.sensorsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // SensorManager
    private lateinit var sensorManager: SensorManager

    // Sensor
    private var mAccelerometerSensor: Sensor? = null
    private var mMagneticFieldSensor: Sensor? = null

    // Sensorの値
    private var mAccelerometerValue: FloatArray = FloatArray(3)
    private var mMagneticFieldValue: FloatArray = FloatArray(5)

    // 一度でも地磁気センサーの値を取得したか
    private var mMagneticFiledFlg: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
