package com.zhukovartemvl.verbs.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.zhukovartemvl.shared.model.*
import com.zhukovartemvl.ui.base.adapter.BaseAdapter
import com.zhukovartemvl.ui.base.adapter.BaseAdapterCallback
import com.zhukovartemvl.ui.base.adapter.BaseViewHolder
import com.zhukovartemvl.verbs.R


class VerbsAdapter : BaseAdapter<IrregularVerbItem>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<IrregularVerbItem> {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_verb, parent, false),
            callback = mCallback
        )
    }

    class ViewHolder(itemView: View, var callback: BaseAdapterCallback<IrregularVerbItem>?) :
        BaseViewHolder<IrregularVerbItem>(itemView = itemView) {

        private val txtFirstForm: TextView = itemView.findViewById(R.id.txt_first)
        private val txtSecondForm: TextView = itemView.findViewById(R.id.txt_second)
        private val txtThirdForm: TextView = itemView.findViewById(R.id.txt_third)
        private val txtTranslation: TextView = itemView.findViewById(R.id.txt_translation)

        override fun bind(model: IrregularVerbItem) {
            txtFirstForm.text = model.firstForm
            txtSecondForm.text = model.secondForm
            txtThirdForm.text = model.thirdForm
            txtTranslation.text = model.translation
        }
    }
}
