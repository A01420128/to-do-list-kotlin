package com.example.todolist.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Task(val name: String, val description: String, val priority: Int, val timestamp: String): Parcelable {}
