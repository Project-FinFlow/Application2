package com.example.finflow

import android.app.Application
import com.example.finflow.data.local.AppDatabase
import com.example.finflow.data.repository.FinFlowRepositories

class FinFlowApplication : Application() {
    val database: AppDatabase by lazy {
        AppDatabase.getDatabase(this)
    }

    val repositories: FinFlowRepositories by lazy {
        FinFlowRepositories(database)
    }
}
