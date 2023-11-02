package com.example.myapp.thread

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.Random

fun main(): Unit = runBlocking {
    launch {
        val result = doWork("Hello new job")
        println(result)
    }
}

suspend fun doWork(name: String): String {
    delay(Random().nextInt(5000).toLong())
    return "Done.$name"
}