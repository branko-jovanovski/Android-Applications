package com.example.android_viewmodel_slicing

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.android_viewmodel_slicing.data.Exam
import com.example.android_viewmodel_slicing.data.PassedExam
import com.example.android_viewmodel_slicing.data.Student

class StudentViewModel : ViewModel() {

    var students = mutableStateOf(
        listOf(
            Student(
                id = 1,
                studentNumber = "10443",
                firstName = "John",
                lastName = "Smith",
                yearOfAdmission = 2023,
                passedExams = listOf(
                    PassedExam(
                        exam = Exam(1, "Mathematics"),
                        grade = 9
                    ),
                    PassedExam(
                        exam = Exam(2, "Computer Programming"),
                        grade = 10
                    )
                )
            ),
            Student(
                id = 2,
                studentNumber = "10458",
                firstName = "Sarah",
                lastName = "Johnson",
                yearOfAdmission = 2023,
                passedExams = emptyList()
            )
        )
    )
        private set

    var exams = mutableStateOf(
        listOf(
            Exam(1, "Mathematics"),
            Exam(2, "Computer Programming"),
            Exam(3, "Database Systems")
        )
    )
        private set

    var selectedStudent = mutableStateOf<Student?>(null)
        private set

    private var nextStudentId = 3
    private var nextExamId = 4

    fun addStudent(
        studentNumber: String,
        firstName: String,
        lastName: String,
        yearOfAdmission: Int
    ) {
        val newStudent = Student(
            id = nextStudentId,
            studentNumber = studentNumber,
            firstName = firstName,
            lastName = lastName,
            yearOfAdmission = yearOfAdmission
        )

        nextStudentId++

        students.value = students.value + newStudent
    }

    fun selectStudent(student: Student) {
        selectedStudent.value = student
    }

    fun addExam(name: String) {
        val newExam = Exam(
            id = nextExamId,
            name = name
        )

        nextExamId++
        exams.value = exams.value + newExam
    }

    fun addPassedExamToSelectedStudent(
        exam: Exam,
        grade: Int
    ) {
        val currentStudent = selectedStudent.value ?: return

        val updatedStudent = currentStudent.copy(
            passedExams = currentStudent.passedExams + PassedExam(
                exam = exam,
                grade = grade
            )
        )

        students.value = students.value.map { student ->
            if (student.id == updatedStudent.id) {
                updatedStudent
            } else {
                student
            }
        }

        selectedStudent.value = updatedStudent
    }
}