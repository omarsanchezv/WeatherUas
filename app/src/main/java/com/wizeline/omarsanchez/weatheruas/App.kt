package com.wizeline.omarsanchez.weatheruas

import android.app.Application
import com.wizeline.omarsanchez.weatheruas.data.DataRepositorie

class App:Application(){

    val repositorie = DataRepositorie()

}