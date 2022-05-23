package com.madapp.easydi.app

import android.util.Log
import com.madapp.easydi.app.Animal

class Cat : Animal() {
    override fun makeSound() {
        Log.i("DI", "Meow");
    }
}