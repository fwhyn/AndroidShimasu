package com.luthtan.broadcast.base

import androidx.databinding.BindingAdapter
import androidx.viewpager2.widget.ViewPager2
import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.EpoxyRecyclerView
import com.luthtan.broadcast.data.dtos.AppliEpoxyModel
import com.luthtan.broadcast.feature.epoxy.EpoxyListener
import com.luthtan.broadcast.viewPager
import com.luthtan.broadcast.viewPagerItem

object BindingAdapter {

    @BindingAdapter(value = ["epoxyController", "listener", "position"])
    @JvmStatic
    fun ViewPager2.bindViewPager2(epoxy: EpoxyController, listener: EpoxyListener, position: Int) {
        adapter = epoxy.adapter
        registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                listener.onViewPagerPosition(position)
            }
        })
        currentItem = position
    }

    @BindingAdapter("models")
    @JvmStatic
    fun EpoxyRecyclerView.bindRecyclerView(appliEpoxyModel: AppliEpoxyModel) {
        setModels(appliEpoxyModel.models)
    }

}