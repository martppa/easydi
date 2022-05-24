package com.madapp.easydi.lib

open class Beacon(private val builder: () -> Any) {
    open operator fun invoke() = builder()
}