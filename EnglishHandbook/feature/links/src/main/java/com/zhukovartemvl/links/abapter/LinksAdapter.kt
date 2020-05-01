package com.zhukovartemvl.links.abapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.zhukovartemvl.links.R
import com.zhukovartemvl.shared.model.*
import com.zhukovartemvl.ui.base.adapter.BaseAdapter
import com.zhukovartemvl.ui.base.adapter.BaseAdapterCallback
import com.zhukovartemvl.ui.base.adapter.BaseViewHolder


class LinksAdapter : BaseAdapter<LinkItem>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<LinkItem> {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_link, parent, false),
            callback = mCallback
        )
    }

    class ViewHolder(itemView: View, var callback: BaseAdapterCallback<LinkItem>?) :
        BaseViewHolder<LinkItem>(itemView = itemView) {

        private val txtText: TextView = itemView.findViewById(R.id.txt_text)
        private val txtLink: TextView = itemView.findViewById(R.id.txt_link)

        override fun bind(model: LinkItem) {
            txtText.text = model.text
            txtLink.text = model.link
        }
    }
}
