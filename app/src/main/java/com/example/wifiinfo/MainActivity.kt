package com.example.wifiinfo

import android.content.Context
import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnwifiManager = findViewById<Button>(R.id.button) as Button
        val wifiText = findViewById<TextView>(R.id.wifiList) as TextView

        btnwifiManager.setOnClickListener {
            val wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
            val wifiInnfo = wifiManager.connectionInfo
            val ipAddress:Int = wifiInnfo.ipAddress
            val bssid:String = wifiInnfo.ssid
            val macAddress:String = wifiInnfo.macAddress
            val ssid:String = wifiInnfo.ssid
            val linkSpeed :Int = wifiInnfo.linkSpeed
            val rssi:Int = wifiInnfo.rssi
            val networkId :Int = wifiInnfo.networkId
            val ipAdressFormat = android.text.format.Formatter.formatIpAddress(ipAddress)

            val wifiInfoList:String = "IP Address:-$ipAdressFormat \nBSSID:-$bssid \nMAC Address:-$macAddress \nSSID:-$ssid"+
                    "\nLink Speed:-$linkSpeed \nRSSI:-$rssi \nNetwork Id:-$networkId"

            wifiText.text = wifiInfoList
        }

    }
}