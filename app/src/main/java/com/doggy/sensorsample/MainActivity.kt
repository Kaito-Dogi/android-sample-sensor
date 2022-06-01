package com.doggy.sensorsample

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.doggy.sensorsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), SensorEventListener {

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

        // SensorManagerのインスタンスを生成
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        // 加速度センサーを取得する
        mAccelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        // 地磁気センサーを取得する
        mMagneticFieldSensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD)
    }

    // センサーの精度が変化した時の処理
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        /* 何もしない */
    }

    // センサーの値が変化した時の処理
    override fun onSensorChanged(event: SensorEvent?) {
        // とりあえず値を出力してみる（後で消す）
        Log.d("SENSOR", event?.values?.getOrNull(0).toString())
    }
}
