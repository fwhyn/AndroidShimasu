package com.fwhyn.myapplication.ui.common.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fwhyn.android.data.model.SdkModel
import com.fwhyn.android.databinding.TextRowItemBinding

class CustomAdapter(
    private val dataSet: List<SdkModel>,
    private val clickListener: (SdkModel) -> Unit,
) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view =
            TextRowItemBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.bind(dataSet[position])
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        lateinit var textItem: TextView

        constructor(itemBinding: TextRowItemBinding) : this(itemBinding.root) {
            textItem = itemBinding.textElement
        }

        fun bind(sdkModel: SdkModel) {
            textItem.text = sdkModel.name

            textItem.setOnClickListener {
                clickListener(sdkModel)
            }
        }
    }
}