package com.madapp.easydi.lib

object BeaconBuilder {
    fun build(builder: () -> Any, singleton: Boolean): Beacon {
        return if (singleton) {
            SingleBeacon(builder)
        } else {
            Beacon(builder)
        }
    }
}