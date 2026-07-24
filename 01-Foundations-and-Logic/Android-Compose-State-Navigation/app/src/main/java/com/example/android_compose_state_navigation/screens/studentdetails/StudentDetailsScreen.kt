package com.example.android_compose_state_navigation.screens.studentdetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.android_compose_state_navigation.data.Student

@Composable
fun StudentDetailsScreen(
    student: Student?,
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = "Student details",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            if (student != null) {
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "Full name : ${student.firstName} ${student.lastName}",
                            style = MaterialTheme.typography.titleLarge
                        )

                        Text(
                            text = "Student number : ${student.studentNumber}",
                            style = MaterialTheme.typography.titleLarge
                        )

                        Text(
                            text = "Admission year : ${student.yearOfAdmission}",
                            style = MaterialTheme.typography.titleLarge
                        )

                        Text(
                            text = "Average grade : ${student.averageGrade}",
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                }
            } else {
                Text(
                    text = "No student selected",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }

        Button(
            onClick = onBackClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back")
        }
    }
}