package com.composepractice.coroutinespractice

import android.os.Build
import androidx.annotation.RequiresApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.time.Instant

//Coroutine Scope:

suspend fun doWork()
{
    delay(1000)
    println("Work Done")
}



suspend fun longTask(){
    println("executing longTask on...: ${Thread.currentThread().name}")
    delay(1000)
    println("longTask ends on thread ...: ${Thread.currentThread().name}")
}

fun main() = runBlocking {
    repeat(1000) {
        launch(Dispatchers.Default) { // will get dispatched to DefaultDispatcher
            println("Default  : running in thread ${Thread.currentThread().name}")
            longTask()
        }
    }
}

//@RequiresApi(Build.VERSION_CODES.O)
//fun main() = runBlocking {
//
//    println("${Instant.now()}: My program runs...: ${Thread.currentThread().name}")
//
//    val productId = findProduct()
//
//    launch (Dispatchers.Unconfined) { // start a coroutine
//        val price = fetchPrice(productId) // call the suspending function
//        println(price)
//    }
//    updateProduct()
//
//    println("${Instant.now()}: My program run ends...: " + "${Thread.currentThread().name}")
//}

//suspend fun longRunningTask(){
//    println("executing longRunningTask on...: ${Thread.currentThread().name}")
//    delay(1000)  // simulating the slow behavior by adding a delay
//    println(
//        "longRunningTask ends on thread ...: ${Thread.currentThread().name}")
//}

@RequiresApi(Build.VERSION_CODES.O)
suspend fun fetchPrice(productId: String) : Double{
    println("${Instant.now()}: fetchPrice starts on...:${Thread.currentThread().name} ")
    delay(2000) // simulate the slow function by adding a delay
    println("${Instant.now()}: fetchPrice ends on...:${Thread.currentThread().name} ")
    return 234.5
}

@RequiresApi(Build.VERSION_CODES.O)
fun findProduct() : String{
    println("${Instant.now()}: findProduct on...: ${Thread.currentThread().name}")
    return "P12333"
}

@RequiresApi(Build.VERSION_CODES.O)
fun updateProduct() : String{
    println("${Instant.now()}: updateProduct on...: ${Thread.currentThread().name}")
    return "Product updated"
}

//Output
/*
2022-06-24T04:09:40..: My program runs...: main
2022-06-24T04:09:40..: findProduct on...: main
2022-06-24T04:09:40..: fetchPrice starts on...: main
2022-06-24T04:09:40..: updateProduct on...: main
2022-06-24T04:09:40..: My program run ends...: main
2022-06-24T04:09:42..: fetchPrice ends on.: kotlinx.coroutines.DefaultExecutor
*/

/*
As we can see the from the output, the findProduct() and updateProduct() functions are called on the main thread.
The fetchPrice() function starts on the main thread and is suspended to allow execution of the findProduct() and updateProduct() functions on the main thread.
The fetchPrice() function resumes on a different thread to execute the println() statement.
It is also important to understand that suspending functions can only be invoked by another suspending function or from a coroutine.
The delay() function called inside the fetchPrice() function is also a suspending function provided by the kotlinx-coroutines-core library.
*/



