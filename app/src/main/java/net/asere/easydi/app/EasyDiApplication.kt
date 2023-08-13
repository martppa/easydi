package net.asere.easydi.app

import android.app.Application
import net.asere.easydi.lib.inject
import net.asere.easydi.lib.register

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