package com.ricardofachini.rummikubcalculator

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class RummikubCalculatorApplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }
}