package net.asere.easydi.app

import android.util.Log

class Dog : Animal() {
    override fun makeSound() {
        Log.i("DI", "Woof");
    }
}