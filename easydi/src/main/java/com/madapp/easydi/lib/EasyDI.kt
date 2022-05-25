package com.madapp.easydi.lib

val beacons: MutableMap<String, Beacon> = mutableMapOf()
fun key(clazz: String, name: String) = "${clazz}__$name"

inline fun <reified T : Any> register(
    name: String = String.empty(),
    singleton: Boolean = false,
    noinline creator: () -> T) {
    val key = key(T::class.java.name, name)
    beacons[key] = buildBeacon(creator, singleton)
}

inline fun <reified T> inject(name: String = String.empty()): T {
    val key = key(T::class.java.name, name)
    val beacon = beacons[key]
        ?: throw BeaconNotFoundException(key)
    return beacon.invoke() as T
}

fun buildBeacon(creator: () -> Any, singleton: Boolean): Beacon {
    return if (singleton) {
        SingleBeacon(creator)
    } else {
        Beacon(creator)
    }
}
