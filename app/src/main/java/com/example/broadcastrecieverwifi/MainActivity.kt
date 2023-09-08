package com.example.broadcastrecieverwifi

import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private val wifiChangeReceiver = WifiChangeModeReciever()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Register the BroadcastReceiver with the intent filter
        val intentFilter = IntentFilter(WifiManager.NETWORK_STATE_CHANGED_ACTION)
        registerReceiver(wifiChangeReceiver, intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()

        // Unregister the BroadcastReceiver when the activity is destroyed
        unregisterReceiver(wifiChangeReceiver)
    }
}