package com.example.coroutinesexamples.Coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.coroutinesexamples.Coroutines.ViewModel.ScopeViewModel
import com.example.coroutinesexamples.R
import com.example.coroutinesexamples.databinding.ActivityAllScopesBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AllScopesActivity : AppCompatActivity() {

    private lateinit var viewModel: ScopeViewModel
    private lateinit var binding: ActivityAllScopesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_all_scopes)
        binding = ActivityAllScopesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        viewModel = ViewModelProvider(this).get(ScopeViewModel::class.java)

        setListeners()
        binding.customScope.setOnClickListener {
            customScope()
            finish()
        }
        binding.lifeCycleScope.setOnClickListener {
            lifeCycleScope()
            finish()
        }
        binding.globalScope.setOnClickListener {
            globalScope()
            finish()
        }
        binding.viewModelScope.setOnClickListener {
            viewModel.getString()
        }

    }

    fun lifeCycleScope() {
        lifecycleScope.launch {
            doWork()
        }
    }

    fun globalScope() {
        GlobalScope.launch {
            doWork()
        }

    }

    private fun customScope() {
        CoroutineScope(IO).launch {
            doWork()
        }
    }


    private fun setListeners() {
        viewModel.liveData.observe(this, Observer { binding.scopeText.text = "Result is : $it" })
    }

    private suspend fun doWork() {
        Log.v("Paytm", "Work Started")
        delay(5000)
        Log.v("Paytm", "Work Ended")
    }

}