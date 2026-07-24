package com.example.android_compose_state_navigation.navigation

import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.android_compose_state_navigation.data.Student
import com.example.android_compose_state_navigation.screens.addstudent.AddStudentScreen
import com.example.android_compose_state_navigation.screens.studentdetails.StudentDetailsScreen
import com.example.android_compose_state_navigation.screens.studentlist.StudentListScreen

@Composable
fun StudentNavHost() {
    val navController = rememberNavController()

    var students by remember {
        mutableStateOf(
            listOf(
                Student("10458", "John", "Smith", 8.50, 2021),
                Student("10568", "Sarah", "Johnson", 9.20, 2022),
                Student("10679", "Michael", "Brown", 9.80, 2023)
            )
        )
    }

    var selectedStudent by remember {
        mutableStateOf<Student?>(null)
    }

    NavHost(
        navController = navController,
        startDestination = Routes.STUDENT_LIST,
        modifier = Modifier.safeDrawingPadding()
    ) {
        composable(
            Routes.STUDENT_LIST
        ) {
            StudentListScreen(
                students = students,
                onAddClick = {
                    navController.navigate(Routes.ADD_STUDENT)
                },
                onStudentClick = { student ->
                    selectedStudent = student
                    navController.navigate(Routes.STUDENT_DETAILS)
                }
            )
        }

        composable(
            Routes.ADD_STUDENT
        ) {
            AddStudentScreen(
                onSaveStudent = { student ->
                    students = students + student
                    navController.popBackStack()
                },
                onCancel = {
                    navController.popBackStack()
                }
            )
        }

        composable(Routes.STUDENT_DETAILS) {
            StudentDetailsScreen(
                student = selectedStudent,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}