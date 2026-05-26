package com.example.finflow

import android.app.Application
import com.example.finflow.data.local.AppDatabase

class FinFlowApplication : Application() {
    val database: AppDatabase by lazy {
        AppDatabase.getDatabase(this)
    }
}
