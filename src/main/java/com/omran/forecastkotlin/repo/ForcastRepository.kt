package com.omran.forecastkotlin.repo

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.omran.forecastkotlin.model.DailyForcast
import kotlin.random.Random

class ForcastRepository(val context: Context){


    //create list from your model private to can make any change when data update until you make operation
    //on it before update
    private val _weeklyForcast = MutableLiveData<List<DailyForcast>>()

    //make list public to make update for data
    // use to call obsever to list to change data and load it
    val weeklyForcast :LiveData<List<DailyForcast>> = _weeklyForcast


    //function make update for data to listen to change data
    fun loadData(zipCode : String){
        val randomValues = List(7){
            Random.nextFloat().rem(100)*100
        }
        val forcastItem = randomValues.map {
            DailyForcast(forcast =  it, temp = "Parshely Cloudey")
        }

        if (zipCode.length != 5){
            Toast.makeText( context ,"Not Ture Zip Code ENter Anthor One}", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(context ,"Loading Data Her ", Toast.LENGTH_SHORT).show()

        }
        _weeklyForcast.setValue(forcastItem)

    }

}