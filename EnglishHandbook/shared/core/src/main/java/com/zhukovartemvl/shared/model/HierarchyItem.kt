package com.zhukovartemvl.shared.model


data class HierarchyItem(
    val id: Int,
    val parentId: Int,
    val key: String,
    val type: Int,
    val text: String
)
