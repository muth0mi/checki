package io.github.muth0mi.cheki.cheki

import android.content.Context
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.IOException
import java.net.InetSocketAddress
import java.net.Socket

private const val TAG = "InternetChecker"

/**
 * A livedata object containing the current internet status.
 *
 * This class checks whether or not internet is accessible.
 *
 * @param context application context to use.
 * @param interval milliseconds to wait before checking change of internet status.
 * @property connectionChecker [ConnectionChecker] object to check connection status.
 * @constructor Obtain a livedata object with the internet status.
 */
class InternetChecker(context: Context, private val interval: Long = 3000) : LiveData<Boolean>() {
    private val connectionChecker: ConnectionChecker = ConnectionChecker(context)

    override fun observe(owner: LifecycleOwner, observer: Observer<in Boolean>) {
        super.observe(owner, observer)
        connectionChecker.observe(owner, { connected ->
            if (connected) checkInternetStatus()
            else postValue(false)
        })
    }

    private fun checkInternetStatus() = CoroutineScope(Dispatchers.IO).launch {
        while (true) {
            val hasInternet = doesNetworkHaveInternet()
            if (hasInternet != value) postValue(hasInternet)
            delay(interval)
        }
    }

    /**
     * Send a ping to googles primary DNS.
     * If successful, that means we have internet.
     */
    private fun doesNetworkHaveInternet(): Boolean {
        return try {
            Log.d(TAG, "PINGING google.")
            val socket = Socket()
            socket.connect(InetSocketAddress("8.8.8.8", 53), 1500)
            socket.close()
            Log.d(TAG, "PING success.")
            true
        } catch (e: IOException) {
            Log.e(TAG, "No internet connection. $e")
            false
        }
    }
}