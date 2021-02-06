package io.github.muth0mi.cheki.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import io.github.muth0mi.cheki.cheki.ConnectionChecker
import io.github.muth0mi.cheki.cheki.InternetChecker

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme { ChekiDemoApp() }
        }
    }

    @Composable
    fun ChekiDemoApp() {
        Scaffold(
            topBar = { TopAppBar(title = { Text(text = "Cheki Demo") }) },
            bodyContent = {
                ConnectionChecker(this).observe(this, { connected ->
                })
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