package com.composepractice.coroutinespractice

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// Basic Coroutines
fun main()
{
    println("Start")
    GlobalScope.launch {
        delay(1000)
        println("Hello")
    }
    Thread.sleep(2000)
    println("End")
}