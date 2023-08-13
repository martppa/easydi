package net.asere.easydi.lib

class BeaconNotFoundException(identifier: String)
    : Exception("No definition found for $identifier")