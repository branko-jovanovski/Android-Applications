package com.example.android_viewmodel_slicing.screens.studentlist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.android_viewmodel_slicing.data.Student

@Composable
fun StudentRow(
    student: Student,
    onStudentCardClick: (Student) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = { onStudentCardClick(student) }
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = student.studentNumber)

            Text(text = student.firstName)

            Text(text = student.lastName)
        }
    }
}