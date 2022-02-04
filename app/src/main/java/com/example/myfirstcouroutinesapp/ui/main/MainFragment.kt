package com.example.myfirstcouroutinesapp.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myfirstcouroutinesapp.R
import com.example.myfirstcouroutinesapp.databinding.MainFragmentBinding
import kotlinx.coroutines.*

class MainFragment : Fragment(R.layout.main_fragment) {

    // usando viewbinding ver tutorial
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    // meu escopo de coroutines
    // dispatchers faz com que o código dela seja postado na Main Thread
    // ( nela há uma fila de operações para rodar nela)
    private val coroutineScope = CoroutineScope(Dispatchers.Main.immediate)

    // criando o Job
    private var job :Job? = null

    // variável que irá alterar o contador
    var num = 0


    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // update ->  looping (parar quando clicar stop  Job e dar um cancel no coroutines)  : delay ( 500) fazer update

        binding.buttonStart.setOnClickListener {
            // start contador ->
            //updated

            job = coroutineScope.launch {
               while (true) {
                   binding.counterClock.text = num.toString()
                   num++
                   delay(500)
                   //start
                   //update
               }
            }
        }

        binding.buttonStop.setOnClickListener {
           // parar o contador
            //testing git new key
            job?.cancel()


        }

    }

    // to avoid memory leaks
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
       // caso a coroutines tivesse mais de um job,
    // deveriamos cancelar todos os jobs antes da view ser destruida,
    // e para isso cancelaríamos a coroutines onde eles estão:
      //  coroutineScope.coroutineContext.cancelChildren()
    }

    // git???

}