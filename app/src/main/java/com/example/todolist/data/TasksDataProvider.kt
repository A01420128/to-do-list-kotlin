package com.example.todolist.data

object TasksDataProvider {
    fun getData(): List<Task> {
        return listOf(
            Task("Name1", "desc", 40, "20220318_173657"),
            Task("Name2", "desc", 40, "20220318_173657"),
            Task("Name3", "desc", 40, "20220318_173657"),
            Task("Name4", "desc", 40, "20220318_173657"),
            Task("Name5", "desc", 40, "20220318_173657"),
            Task("Name6", "desc", 40, "20220318_173657"),
            Task("Name7", "desc", 40, "20220318_173657"),
            Task("Name8", "desc", 40, "20220318_173657"),
            Task("Name9", "desc", 40, "20220318_173657"),
            Task("Name10", "desc", 40, "20220318_173657")
        )
    }
}