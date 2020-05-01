package com.zhukovartemvl.dictionary.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.zhukovartemvl.dictionary.R
import com.zhukovartemvl.shared.model.*
import com.zhukovartemvl.ui.base.adapter.BaseAdapter
import com.zhukovartemvl.ui.base.adapter.BaseAdapterCallback
import com.zhukovartemvl.ui.base.adapter.BaseViewHolder


class DictionaryAdapter : BaseAdapter<DictionaryItem>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<DictionaryItem> {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_dictionary, parent, false),
            callback = mCallback
        )
    }

    class ViewHolder(itemView: View, var callback: BaseAdapterCallback<DictionaryItem>?) :
        BaseViewHolder<DictionaryItem>(itemView = itemView) {

        private val txtText: TextView = itemView.findViewById(R.id.txt_text)
        private val txtTranslation: TextView = itemView.findViewById(R.id.txt_translation)

        override fun bind(model: DictionaryItem) {
            txtText.text = model.text
            txtTranslation.text = model.translation
        }
    }
}
