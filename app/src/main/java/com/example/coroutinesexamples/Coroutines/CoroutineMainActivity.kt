package com.example.coroutinesexamples.Coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.coroutinesexamples.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class CoroutineMainActivity : AppCompatActivity() {
    val TAG= "CoroutineActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine_main)

        GlobalScope.launch {
            Log.e(TAG,"says hello from thread ${Thread.currentThread().name}")
            val networkcall= doNetworkCall()
            Log.e(TAG,"call the network $networkcall")

        }


        val job = GlobalScope.launch(Dispatchers.Default) {
            repeat(5){
                Log.e(TAG,"Coroutine still working.....")
                delay(1000L)

            }
        }
        runBlocking {
            job.join() // once you try to complete a coroutine
            /*
            * cancel a coroutine*/
            delay(2000L)
            job.cancel()
            Log.e(TAG,"Main thread is continuing.....")
        }
    }
    suspend fun doNetworkCall():String{
        delay(1000L)
        Log.d(TAG,"Network call using suspend fun")
        return "this is answer"
    }

    //fibonaci number
    fun fib(n:Int):Long{
        return if (n==0)0
        else if (n==1) 1
        else fib(n-1) + fib(n-2)
    }



    /*
    * public fun loadWeather() {
        //get cached item but don't fail if the cache is empty
        val cachedWeather = weatherCache.getWeather()
            .onErrorResumeNext { Observable.empty() }

        val serviceWeather = weatherService.getWeather()
            .doOnNext(weatherCache::updateCache)

        compositeDisposable.add(
            Observable.concat(cachedWeather, serviceWeather)
                .distinctUntilChanged()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ weatherEvent ->
                findViewById<TextView>(R.id.temperature_text_view).text = weatherEvent.description
                findViewById<TextView>(R.id.weatherTextView).text = weatherEvent.temperature
            }, { it ->
                findViewById<TextView>(R.id.weatherTextView).text = "OOPS"
                findViewById<TextView>(R.id.temperature_text_view).text = "WEATHER FAILED TRY AGAIN LATER"
                it.printStackTrace()
            })
        )
    }

}*/

}