package com.example.android_compose_state_navigation.screens.addstudent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.android_compose_state_navigation.data.Student

@Composable
fun AddStudentScreen(
    onSaveStudent: (Student) -> Unit,
    onCancel: () -> Unit
) {
    var studentNumber by remember { mutableStateOf("") }
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var averageGrade by remember { mutableStateOf("") }
    var yearOfAdmission by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Add student",
            style = MaterialTheme.typography.headlineMedium
        )

        OutlinedTextField(
            value = studentNumber,
            onValueChange = { studentNumber = it },
            label = { Text("Student number") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = firstName,
            onValueChange = { firstName = it },
            label = { Text("First name") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = lastName,
            onValueChange = { lastName = it },
            label = { Text("Last name") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = averageGrade,
            onValueChange = { averageGrade = it },
            label = { Text("Average grade") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = yearOfAdmission,
            onValueChange = { yearOfAdmission = it },
            label = { Text("Year of admission") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                val student = Student(
                    studentNumber = studentNumber,
                    firstName = firstName,
                    lastName = lastName,
                    averageGrade = averageGrade.toDoubleOrNull() ?: 0.0,
                    yearOfAdmission = yearOfAdmission.toIntOrNull() ?: 2026
                )

                onSaveStudent(student)
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = studentNumber.isNotBlank() &&
                    firstName.isNotBlank() &&
                    lastName.isNotBlank() &&
                    averageGrade.isNotBlank() &&
                    yearOfAdmission.isNotBlank()
        ) {
            Text("Add student")
        }

        OutlinedButton(
            onClick = onCancel,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Cancel")
        }
    }
}