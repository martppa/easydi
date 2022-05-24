package com.madapp.easydi.lib

import java.lang.Exception

object EasyDI {
    val beacons: MutableMap<String, Beacon> = mutableMapOf()
}

inline fun <reified T : Any> register(
    name: String = String.empty(),
    singleton: Boolean = false,
    noinline builder: () -> T) {
    EasyDI.beacons["${T::class.java.name}_$name"] = BeaconBuilder.build(builder, singleton)
}

inline fun <reified T> inject(name: String = String.empty()): T {
    val beacon = EasyDI.beacons["${T::class.java.name}_$name"]
        ?: throw Exception("No definition for ${T::class.java.name}")
    return beacon.invoke() as T
}
