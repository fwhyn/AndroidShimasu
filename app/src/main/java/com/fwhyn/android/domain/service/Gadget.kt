package com.fwhyn.android.domain.service

sealed class Gadget(val name: String) {

    class Laptop : Gadget("Laptop")
    class Smartphone : Gadget("Smartphone")
    class Others {
        val test = "test"
    }
}
