package com.example.android_viewmodel_slicing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.android_viewmodel_slicing.navigation.StudentNavHost
import com.example.android_viewmodel_slicing.ui.theme.AndroidViewModelSlicingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidViewModelSlicingTheme {
                val studentViewModel: StudentViewModel = viewModel()

                StudentNavHost(
                    studentViewModel = studentViewModel
                )
            }
        }
    }
}