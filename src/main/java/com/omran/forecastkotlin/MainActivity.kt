package com.omran.forecastkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.omran.forecastkotlin.model.DailyForcast
import com.omran.forecastkotlin.repo.ForcastRepository

import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {

    val forcast = ForcastRepository(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        submit.setOnClickListener {
            val valueBackFromEditText = zipcode.text.toString()
            forcast.loadData(valueBackFromEditText)
        }

        val WeeklyForcastObsever = Observer<List<DailyForcast>> {
           // Toast.makeText(this ,"Loading Is Start ", Toast.LENGTH_SHORT).show()

        }
        forcast.weeklyForcast.observe(this,WeeklyForcastObsever)

    }


}