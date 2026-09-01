package com.example.android_viewmodel_slicing.screens.addexam

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.android_viewmodel_slicing.data.Exam

@Composable
fun ExamRow(
    exam: Exam
) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = exam.name,
            modifier = Modifier.padding(16.dp)
        )
    }
}