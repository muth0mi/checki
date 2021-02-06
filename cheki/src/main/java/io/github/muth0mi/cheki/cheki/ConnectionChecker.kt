package io.github.muth0mi.cheki.cheki

import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities.NET_CAPABILITY_INTERNET
import android.net.NetworkRequest
import android.util.Log
import androidx.lifecycle.LiveData

private const val TAG = "ConnectionChecker"

/**
 * A livedata object containing the current network availability status.
 *
 * This class checks whether or not network connection is available.
 *
 * @param context application context to use.
 * @constructor Obtain a livedata object with the connection status.
 */
open class ConnectionChecker(context: Context) : LiveData<Boolean>() {
    private lateinit var networkCallback: ConnectivityManager.NetworkCallback
    private val cm = context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
    private val validNetworks: MutableSet<Network> = HashSet()

    override fun onActive() {
        networkCallback = createNetworkCallback()
        val networkRequest = NetworkRequest.Builder()
            .addCapability(NET_CAPABILITY_INTERNET)
            .build()
        cm.registerNetworkCallback(networkRequest, networkCallback)
    }

    override fun onInactive() = cm.unregisterNetworkCallback(networkCallback)

    private fun createNetworkCallback() = object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            Log.d(TAG, "onAvailable: $network")
            val networkCapabilities = cm.getNetworkCapabilities(network)
            val connected = networkCapabilities?.hasCapability(NET_CAPABILITY_INTERNET) ?: false
            Log.d(TAG, "onAvailable: $network, $connected")
            if (connected) validNetworks.add(network)
            postValue(validNetworks.size > 0)
        }

        override fun onLost(network: Network) {
            Log.d(TAG, "onLost: $network")
            validNetworks.remove(network)
            postValue(validNetworks.size > 0)
        }
    }
}