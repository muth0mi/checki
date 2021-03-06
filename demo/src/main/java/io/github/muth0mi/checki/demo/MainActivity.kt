package io.github.muth0mi.checki.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import io.github.muth0mi.checki.ConnectionChecker
import io.github.muth0mi.checki.InternetChecker

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme { DemoApp() }
        }
    }

    @Composable
    fun DemoApp() {
        Scaffold(
            bodyContent = {
                /*
                // Observe in non compose UI like so
                ConnectionChecker(this).observe(this, { connected ->
                    // Do your thing with [connected]
                })
                */
                val connected = ConnectionChecker(this).observeAsState(false).value
                val connectionStatus = if (connected) "Connected" else "Disconnected"
                val online = InternetChecker(this).observeAsState(false).value
                val internetStatus = if (online) "Online" else "Offline"
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = connectionStatus,
                        style = MaterialTheme.typography.h5,
                        color = if (connected) Color.Green else Color.Red,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(16.dp)
                    )
                    Text(
                        text = internetStatus,
                        style = MaterialTheme.typography.body2,
                        color = if (online) Color.Green else Color.Red,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                }
            }
        )
    }
}