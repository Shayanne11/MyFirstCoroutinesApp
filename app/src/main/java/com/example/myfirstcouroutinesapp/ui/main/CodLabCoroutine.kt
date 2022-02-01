package com.example.myfirstcouroutinesapp.ui.main

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class CodLabCoroutine {

    //sem coroutines
    fun main() {
        val states = arrayOf("Starting", "Doing Task 1", "Doing Task 2", "Ending")
        repeat(3) {
            Thread {
                println("${Thread.currentThread()} has started")
                for (i in states) {
                    println("${Thread.currentThread()} - $i")
                    Thread.sleep(50)
                }
            }.start()
        }
    }

    // minha tentativa

    // ( nela há uma fila de operações para rodar nela)
    private val coroutineScope = CoroutineScope(Dispatchers.Main.immediate)

    // criando o Job
    private var job : Job? = null

    fun turnToCoroutinesCode(){
        //starting
        // doing task 1
        // doint task 2
        // ending


    }


}