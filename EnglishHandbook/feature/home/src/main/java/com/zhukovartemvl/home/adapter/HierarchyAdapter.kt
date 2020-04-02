package com.zhukovartemvl.home.adapter

import android.graphics.Typeface
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.zhukovartemvl.domain.model.*
import com.zhukovartemvl.englishhandbook.R
import com.zhukovartemvl.ui.base.BaseAdapter
import com.zhukovartemvl.ui.base.BaseAdapterCallback
import com.zhukovartemvl.ui.base.BaseViewHolder


class HierarchyAdapter : com.zhukovartemvl.ui.base.BaseAdapter<Category>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): com.zhukovartemvl.ui.base.BaseViewHolder<Category> {
        TODO("Not yet implemented")
    }

    class ViewHolder(itemView: View, var callback: com.zhukovartemvl.ui.base.BaseAdapterCallback<Category>?) :
        com.zhukovartemvl.ui.base.BaseViewHolder<Category>(itemView = itemView) {

        private val background: ConstraintLayout = itemView.findViewById(R.id.item_background)
        private val txtTitle: TextView = itemView.findViewById(R.id.txt_title)
        private val imgDot: ImageView = itemView.findViewById(R.id.img_dot)
        private val imgIcon: ImageView = itemView.findViewById(R.id.img_folder)
        private val imgArrow: ImageView = itemView.findViewById(R.id.img_arrow)

        override fun bind(model: Category) {
            when (model) {
                is BackItem -> {
                    val textColor = ContextCompat.getColor(itemView.context, R.color.categoryTitle)
                    txtTitle.setTextColor(textColor)
                    txtTitle.setText(model.title)
                    imgDot.visibility = View.GONE
                    imgArrow.visibility = View.GONE
                    imgIcon.setImageResource(R.drawable.ic_back)
                }
                is HeaderItem -> {
                    val backgroundColor = ContextCompat.getColor(itemView.context, R.color.header)
                    background.setBackgroundColor(backgroundColor)
                    txtTitle.setText(model.title)
                    txtTitle.setTypeface(null, Typeface.BOLD)
                    imgDot.visibility = View.GONE
                    imgArrow.visibility = View.GONE
                }
                is FolderItem -> {
                    val textColor = ContextCompat.getColor(itemView.context, R.color.categoryTitle)
                    txtTitle.setTextColor(textColor)
                    txtTitle.setText(model.title)
                    imgIcon.setImageResource(model.icon)
                }
                is FileItem -> {
                    val textColor = ContextCompat.getColor(itemView.context, R.color.categoryTitle)
                    txtTitle.setTextColor(textColor)
                    txtTitle.setText(model.title)
                }
            }
        }

    }

    override fun getItemViewType(position: Int) = mDataList[position].type
}