package com.example.coroutinesexamples

import android.content.Intent
import android.os.Build.VERSION_CODES.N
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import androidx.appcompat.app.AppCompatActivity
import com.example.coroutinesexamples.Coroutines.AllScopesActivity
import com.example.coroutinesexamples.Coroutines.BasicCoroutinesTestActivity
import com.example.coroutinesexamples.Coroutines.CoroutineBuilderActivity
import com.example.coroutinesexamples.Coroutines.HandlingExceptionActivity
import com.example.coroutinesexamples.Coroutines.JobsParallelActivity
import com.example.coroutinesexamples.Coroutines.NestedGlobalScopeActivity
import com.example.coroutinesexamples.Coroutines.SequentialCoroutinesActivity
import com.example.coroutinesexamples.databinding.ActivityBioMainBinding
import com.example.coroutinesexamples.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield


class MainActivity : AppCompatActivity() ,OnClickListener{
    private val TAG :String= "Kotlin"

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main)
        binding=ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        listOf(binding.button1, binding.button2, binding.button3, binding.button4, binding.button5, binding.button6, binding.button7).forEach {
            it.setOnClickListener(this)
        }
    }

    override fun onClick(v: View?) {
        var intent:Intent?= null
        v?.let {
            when(it?.id){
                R.id.button1 -> intent = Intent(this@MainActivity,BasicCoroutinesTestActivity::class.java)
                R.id.button2 -> intent = Intent(this@MainActivity,CoroutineBuilderActivity::class.java)
                R.id.button3 -> intent = Intent(this@MainActivity,SequentialCoroutinesActivity::class.java)
                R.id.button4 -> intent = Intent(this@MainActivity,JobsParallelActivity::class.java)
                R.id.button5 -> intent = Intent(this@MainActivity,AllScopesActivity::class.java)
                R.id.button6 -> intent = Intent(this@MainActivity,NestedGlobalScopeActivity::class.java)
                R.id.button7 -> intent = Intent(this@MainActivity,HandlingExceptionActivity::class.java)

            }
            startActivity(intent)
        }
    }


}