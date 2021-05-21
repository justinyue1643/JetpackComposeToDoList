package com.example.todolistpractice.data

import android.os.Parcelable

data class TaskResponse(val taskName: String?, val TaskID: String?)
data class AllItems(val Items: List<TaskResponse>?, val Count: Int?, val ScannedCount: Int?)
data class Message(val message: String?)