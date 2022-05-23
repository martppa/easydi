package com.madapp.easydi.app

import android.app.Application
import com.madapp.easydi.lib.inject
import com.madapp.easydi.lib.register

class EasyDiApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initializeDependencies()
        val petCare: PetCare = inject()
        petCare.open()
    }

    private fun initializeDependencies() {
        register { PetCare(inject(), inject("cat")) }
        register("cat") { Cat() }
        register { Dog() }
    }
}