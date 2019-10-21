package com.edu.ujcoroutineexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
/**
 * Project Name: KotlinCoroutineExample
 * Created by Umesh Jangid
 * on 21,October,2019
 * @ NIC Ltd
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            setNewText("Click!")
            CoroutineScope(IO).launch {
                apiRequest()
            }
        }
        button1.setOnClickListener {
            startActivity(Intent(this@MainActivity,AnotherCoroutineActivityExam::class.java))
        }
    }
    private fun setNewText(input: String){
        val newText = text.text.toString() + "\n$input"
        text.text = newText
    }
    private suspend fun setOnMainThread(input: String) {
        withContext (Main) {
            setNewText(input)
        }
    }

    private suspend fun apiRequest() {
        logThread("fakeApiRequest")
        val result1 = getResult1FromApi() // wait until job is done
        if ( result1.equals("Result #1")) {
            setOnMainThread("Got $result1")
            val result2 = getResult2FromApi() // wait until job is done
            if (result2.equals("Result #2")) {
                setOnMainThread("Got $result2")
            } else {
                setOnMainThread("Couldn't get Result #2")
            }
        } else {
            setOnMainThread("Couldn't get Result #1")
        }
    }

    private suspend fun getResult1FromApi(): String {
        logThread("getResult1FromApi")
        delay(1000) // Does not block thread. Just suspends the coroutine inside the thread
        return "Result #1"
    }

    private suspend fun getResult2FromApi(): String {
        logThread("getResult2FromApi")
        delay(1000)
        return "Result #2"
    }

    private fun logThread(methodName: String){
        println("debug: ${methodName}: ${Thread.currentThread().name}")
    }

}