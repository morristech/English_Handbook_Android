package com.zhukovartemvl.shared.model


sealed class Category(val type: Int)
data class BackItem(val id: Int, val title: String) : Category(1)
data class Header(val title: String) : Category(2)
data class Folder(val id: Int, val key: String, val title: String) : Category(3)
data class Article(val key: String, val title: String) : Category(4)
data class IrregularVerbs(val key: String, val title: String) : Category(4)
data class Dictionary(val key: String, val title: String) : Category(4)
data class Links(val key: String, val title: String) : Category(4)
data class Title(val key: String, val title: String) : Category(4)
