package com.zhukovartemvl.home.adapter

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.zhukovartemvl.englishhandbook.home.R
import com.zhukovartemvl.shared.model.*
import com.zhukovartemvl.ui.base.adapter.BaseAdapter
import com.zhukovartemvl.ui.base.adapter.BaseAdapterCallback
import com.zhukovartemvl.ui.base.adapter.BaseViewHolder


class HierarchyAdapter : BaseAdapter<Category>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Category> {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false),
            callback = mCallback
        )
    }

    class ViewHolder(itemView: View, var callback: BaseAdapterCallback<Category>?) :
        BaseViewHolder<Category>(itemView = itemView) {

        private val background: ConstraintLayout = itemView.findViewById(R.id.item_background)
        private val txtTitle: TextView = itemView.findViewById(R.id.txt_title)
        private val imgDot: ImageView = itemView.findViewById(R.id.img_dot)
        private val imgFolder: ImageView = itemView.findViewById(R.id.img_folder)
        private val imgArrow: ImageView = itemView.findViewById(R.id.img_arrow)

        override fun bind(model: Category) {
            when (model) {
                is BackItem -> {
                    val textColor = ContextCompat.getColor(itemView.context, R.color.clickableText)
                    txtTitle.setTextColor(textColor)
                    txtTitle.text = model.title
                    txtTitle.setTypeface(null, Typeface.BOLD)
                    imgDot.visibility = View.GONE
                    imgArrow.visibility = View.GONE
                    imgFolder.setImageResource(R.drawable.ic_back)
                }
                is Header -> bindHeader(model.title)
                is Title -> bindHeader(model.title)
                is Folder -> {
                    val textColor = ContextCompat.getColor(itemView.context, R.color.clickableText)
                    txtTitle.setTextColor(textColor)
                    txtTitle.text = model.title
                }
                is Article -> bindItems(model.title)
                is IrregularVerbs -> bindItems(model.title)
                is Dictionary -> bindItems(model.title)
                is Links -> bindItems(model.title)
            }
        }

        private fun bindHeader(title: String){
            val backgroundColor = ContextCompat.getColor(itemView.context, R.color.header)
            background.setBackgroundColor(backgroundColor)
            txtTitle.text = title
            txtTitle.setTypeface(null, Typeface.BOLD)
            imgDot.visibility = View.GONE
            imgArrow.visibility = View.GONE
            imgFolder.visibility = View.GONE
        }

        private fun bindItems(title: String) {
            val textColor = ContextCompat.getColor(itemView.context, R.color.clickableText)
            txtTitle.setTextColor(textColor)
            txtTitle.text = title
            imgFolder.visibility = View.INVISIBLE
        }

    }

    override fun getItemViewType(position: Int) = mDataList[position].type
}
