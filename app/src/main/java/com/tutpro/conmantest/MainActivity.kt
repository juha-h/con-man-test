package com.tutpro.conmantest

import android.net.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val cm = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val builder = NetworkRequest.Builder()
        cm.registerNetworkCallback(
                builder.build(),
                object : ConnectivityManager.NetworkCallback() {

                    override fun onAvailable(network: Network) {
                        super.onAvailable(network)
                        Log.i("ConMan", "Network $network is available")
                    }

                    override fun onLost(network: Network) {
                        super.onLost(network)
                        Log.i("ConMan", "Network $network is lost")
                    }

                    override fun onLinkPropertiesChanged(network: Network, props: LinkProperties) {
                        super.onLinkPropertiesChanged(network, props)
                        Log.i("ConMan", "Network $network link properties changed")
                    }

                    override fun onCapabilitiesChanged(network: Network, caps: NetworkCapabilities) {
                        super.onCapabilitiesChanged(network, caps)
                        Log.i("ConMan", "Network $network capabilities changed: $caps")
                    }
                }
        )

    }
}