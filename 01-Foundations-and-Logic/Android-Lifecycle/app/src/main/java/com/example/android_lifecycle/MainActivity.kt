package com.example.android_lifecycle

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.android_lifecycle.ui.theme.AndroidLifecycleTheme

class MainActivity : ComponentActivity() {

    private val TAG = "LifecycleLog"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        trackLifecycleEvent(
            methodName = "onCreate",
            description = "Activity is created and UI is initialized."
        )

        enableEdgeToEdge()
        setContent {
            AndroidLifecycleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        trackLifecycleEvent(
            methodName = "onStart",
            description = "Activity is becoming visible to the user."
        )
    }

    override fun onResume() {
        super.onResume()
        trackLifecycleEvent(
            methodName = "onResume",
            description = "Activity is in the foreground and ready for user interaction."
        )
    }

    override fun onPause() {
        super.onPause()
        trackLifecycleEvent(
            methodName = "onPause",
            description = "Activity is losing focus but may still be partially visible."
        )
    }

    override fun onStop() {
        super.onStop()
        trackLifecycleEvent(
            methodName = "onStop",
            description = "Activity is no longer visible and has moved to the background."
        )
    }

    override fun onRestart() {
        super.onRestart()
        trackLifecycleEvent(
            methodName = "onRestart",
            description = "Activity is restarting from the background state."
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        trackLifecycleEvent(
            methodName = "onDestroy",
            description = "Activity is being destroyed. Resources are released."
        )
    }

    private fun trackLifecycleEvent(methodName: String, description: String) {
        Log.d(TAG, "$methodName : $description")

        Toast.makeText(this, methodName, Toast.LENGTH_SHORT).show()
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidLifecycleTheme {
        Greeting("Android")
    }
}