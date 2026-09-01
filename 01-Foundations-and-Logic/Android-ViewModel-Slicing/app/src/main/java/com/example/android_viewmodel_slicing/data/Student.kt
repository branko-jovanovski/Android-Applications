package com.example.android_viewmodel_slicing.data

data class Student(
    val studentNumber: String,
    val firstName: String,
    val lastName: String,
    val yearOfAdmission: Int,
    val id: Int,
    val passedExams: List<PassedExam> = emptyList(),
) {
    val averageGrade: Double
        get() = if (passedExams.isEmpty()) {
            0.0
        } else {
            passedExams.map { it.grade }.average()
        }
}