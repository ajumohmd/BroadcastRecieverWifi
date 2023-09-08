package com.example.broadcastrecieverwifi

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.NetworkInfo
import android.net.wifi.WifiInfo
import android.net.wifi.WifiManager
import android.widget.Toast

class WifiChangeModeReciever : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == WifiManager.NETWORK_STATE_CHANGED_ACTION) {
            val networkInfo = intent.getParcelableExtra<NetworkInfo>(WifiManager.EXTRA_NETWORK_INFO)
            if (networkInfo != null && networkInfo.isConnected) {
                // Wi-Fi connection is established or changed
                val wifiManager = context?.getSystemService(Context.WIFI_SERVICE) as WifiManager
                val wifiInfo: WifiInfo? = wifiManager.connectionInfo
                val ssid = wifiInfo?.ssid ?: "Unknown SSID"
                Toast.makeText(context, "Connected to $ssid", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context, "DisConnected", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
