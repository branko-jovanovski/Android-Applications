package com.example.android_viewmodel_slicing.navigation

import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.android_viewmodel_slicing.StudentViewModel
import com.example.android_viewmodel_slicing.screens.addexam.AddExamScreen
import com.example.android_viewmodel_slicing.screens.addstudent.AddStudentScreen
import com.example.android_viewmodel_slicing.screens.addstudentpassedexam.AddStudentPassedExamScreen
import com.example.android_viewmodel_slicing.screens.studentdetails.StudentDetailsScreen
import com.example.android_viewmodel_slicing.screens.studentlist.StudentListScreen

@Composable
fun StudentNavHost(
    studentViewModel: StudentViewModel
) {
    val navController = rememberNavController()
    val context = LocalContext.current
    NavHost(
        navController = navController,
        startDestination = Routes.STUDENT_LIST,
        modifier = Modifier.safeDrawingPadding()
    ) {
        composable(Routes.STUDENT_LIST) {
            StudentListScreen(
                students = studentViewModel.students.value,
                onAddStudentClick = {
                    navController.navigate(Routes.ADD_STUDENT)
                },
                onAddExamClick = {
                    navController.navigate(Routes.ADD_EXAM)
                },
                onStudentCardClick = { student ->
                    studentViewModel.selectStudent(student)
                    navController.navigate(Routes.STUDENT_DETAILS)
                }
            )
        }

        composable(Routes.ADD_STUDENT) {
            AddStudentScreen(
                onSaveStudent = { studentNumber, firstName, lastName, yearOfAdmission ->
                    studentViewModel.addStudent(
                        studentNumber = studentNumber,
                        firstName = firstName,
                        lastName = lastName,
                        yearOfAdmission = yearOfAdmission
                    )
                    navController.popBackStack()
                },
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(Routes.STUDENT_DETAILS) {
            StudentDetailsScreen(
                student = studentViewModel.selectedStudent.value,
                onAddPassedExamClick = {
                    navController.navigate(Routes.ADD_STUDENT_PASSED_EXAM)
                },
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(Routes.ADD_STUDENT_PASSED_EXAM) {
            AddStudentPassedExamScreen(
                exams = studentViewModel.exams.value,
                onSavePassedExam = { exam, grade ->
                    studentViewModel.addPassedExamToSelectedStudent(
                        exam = exam,
                        grade = grade
                    )
                    navController.popBackStack()
                },
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(Routes.ADD_EXAM) {
            AddExamScreen(
                exams = studentViewModel.exams.value,
                onAddExam = { examName ->
                    studentViewModel.addExam(examName)
                },
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}