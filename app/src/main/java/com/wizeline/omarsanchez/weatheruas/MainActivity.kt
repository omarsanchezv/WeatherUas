package com.wizeline.omarsanchez.weatheruas

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import com.wizeline.omarsanchez.weatheruas.adapter.ForecastAdapter
import com.wizeline.omarsanchez.weatheruas.data.models.Forecast
import io.reactivex.Observable
import android.support.design.widget.CollapsingToolbarLayout


class MainActivity : AppCompatActivity() {

    private val adapter by lazy { ForecastAdapter(mutableListOf()) }
    var ctlLayout: CollapsingToolbarLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initToobar()
        initForecast()

    }

    private fun initToobar() {
        val toolbar = findViewById<Toolbar>(R.id.appbar)
        setSupportActionBar(toolbar)

        ctlLayout = findViewById<CollapsingToolbarLayout>(R.id.ctlLayout)
        ctlLayout.apply { title = "Mazatlan" }
    }

    private fun initForecast() {
        val app = this.applicationContext as App
        forecastProvided(app.repositorie.getForecast("mazatlan", "metric", 7))
        val list = findViewById<RecyclerView>(R.id.main_recycler)
        list.adapter = adapter
        list.setHasFixedSize(true)
        list.layoutManager = LinearLayoutManager(this)
    }

    fun forecastProvided(forecasts: Observable<Forecast>) {
        forecasts.doOnNext {
            result(it)
        }
                .doOnError {
                    it.printStackTrace()
                }
                .subscribe()
    }

    fun result(forecast: Forecast) {
        adapter.items = forecast.list
        adapter.notifyDataSetChanged()
    }
}