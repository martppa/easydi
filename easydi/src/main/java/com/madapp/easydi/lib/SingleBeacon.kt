package com.madapp.easydi.lib

class SingleBeacon(builder: () -> Any) : Beacon(builder) {
    private var value: Any? = null;
    override operator fun invoke(): Any {
        if (value == null) value = super.invoke()
        return value!!;
    }
}