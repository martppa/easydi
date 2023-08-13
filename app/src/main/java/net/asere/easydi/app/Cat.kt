package net.asere.easydi.app

import android.util.Log

class Cat : Animal() {
    override fun makeSound() {
        Log.i("DI", "Meow");
    }
}