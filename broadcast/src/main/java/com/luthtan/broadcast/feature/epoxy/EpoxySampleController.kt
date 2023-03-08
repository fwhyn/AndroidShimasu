package com.luthtan.broadcast.feature.epoxy

import com.airbnb.epoxy.TypedEpoxyController
import com.luthtan.broadcast.ViewPagerItemItemBindingModel_
import com.luthtan.broadcast.data.dtos.AppliEpoxyModel
import com.luthtan.broadcast.viewPagerItem

class EpoxySampleController : TypedEpoxyController<List<String>>() {

    override fun buildModels(data: List<String>?) {
        data?.map {
            val model = data.map {
                ViewPagerItemItemBindingModel_()
                    .id(it)
            }
            viewPagerItem {
                id(it)
                model(AppliEpoxyModel(model))
            }
        }
    }
}