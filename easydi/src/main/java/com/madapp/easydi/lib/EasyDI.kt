package com.madapp.easydi.lib

import java.lang.Exception

object EasyDI {
    val beacons: MutableMap<String, () -> Any> = mutableMapOf()
    val named: MutableMap<String, String> = mutableMapOf()
}

inline fun <reified T : Any> register(noinline beaconBuilder: () -> T) {
    EasyDI.beacons[T::class.java.name] = beaconBuilder
}

inline fun <reified T : Any> register(name: String, noinline beaconBuilder: () -> T) {
    val className = T::class.java.name;
    val nameKey = "${className}_${name}"
    EasyDI.named[name] = nameKey
    EasyDI.beacons[nameKey] = beaconBuilder
}

inline fun <reified T> inject(): T {
    val beacon = EasyDI.beacons[T::class.java.name]
        ?: throw Exception("No definition for ${T::class.java.name}")
    return beacon() as T
}

inline fun <reified T> inject(name: String): T {
    val clazz = EasyDI.named[name] ?: throw Exception("No definition for $name")
    return EasyDI.beacons[clazz]!!.invoke() as T
}
