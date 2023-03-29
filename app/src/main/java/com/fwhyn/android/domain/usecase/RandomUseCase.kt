package com.fwhyn.android.domain.usecase

import android.util.Log
import com.fwhyn.android.domain.service.Gadget

class RandomUseCase {
    val tag = "fwhyn_test"
    val laptop = Gadget.Laptop()
    val smartphone = Gadget.Smartphone()
    val others = Gadget.Others()

    fun checkGadget(gadget: Gadget) {
        when (gadget) {
            is Gadget.Laptop -> Log.d(tag, gadget.name)
            is Gadget.Smartphone -> Log.d(tag, gadget.name)
//            else -> {
//                Log.d(tag, others.test)
//            }
        }
    }
}