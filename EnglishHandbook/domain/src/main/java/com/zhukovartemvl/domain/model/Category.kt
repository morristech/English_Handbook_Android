package com.zhukovartemvl.domain.model


sealed class Category(val type: Int)
data class BackItem(val id: Int, val title: Int) : Category(1)
data class TitleItem(val title: Int) : Category(2)
data class SubtitleItem(val title: Int) : Category(3)
data class FolderItem(val id: Int, val key: String, val title: Int, val icon: Int) : Category(4)
data class FileItem(val id: Int, val key: String, val title: Int) : Category(5)