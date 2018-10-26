package com.wizeline.omarsanchez.weatheruas.data.webservices

import com.wizeline.omarsanchez.weatheruas.data.models.Forecast
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.wizeline.omarsanchez.weatheruas.BuildConfig.API_KEY
import com.wizeline.omarsanchez.weatheruas.BuildConfig.BASE_URL
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitApi {
    fun getForecast(place: String, units: String, days: Int): Observable<Forecast> {
        return api.getForecast(place, units, days, API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    private val api: Services by lazy {
        val httpClient = OkHttpClient.Builder().apply {
            addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        }

        Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient.build())
                .build().create(Services::class.java)
    }
}