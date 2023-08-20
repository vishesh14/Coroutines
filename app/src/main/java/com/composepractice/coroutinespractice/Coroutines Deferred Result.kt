package com.composepractice.coroutinespractice

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun fetchUserData() : String
{
    delay(1000)
    return "Fetch User data"

}

//fun main() = runBlocking {
//
//   launch {
//       delay(1000)
//       println("World")
//   }
//    println("Hello")
//}


fun main() = runBlocking{

  launch {
      delay(1000)
      println("World")
  }
    println("Hello")
}

