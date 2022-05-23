package com.madapp.easydi.app

class PetCare(
    private val dog: Dog,
    private val cat: Cat,
) {
    fun open() {
        dog.makeSound()
        cat.makeSound()
    }
}