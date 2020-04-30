package com.zhukovartemvl.shared.repository

import android.content.Context
import com.zhukovartemvl.shared.model.*


interface DatabaseRepository {

    fun initDatabase(context: Context) : Boolean
    fun updateAvailable() : Boolean
    fun updateDatabase(context: Context) : Boolean
    fun getHierarchy(parentId: Int): List<HierarchyItem>
    fun getDatabaseParameter(): DatabaseParametersItem
    fun getArticle(key: String): ArticleItem
    fun getDictionary(key: String): List<DictionaryItem>
    fun getVerbs(key: String): List<IrregularVerbItem>
    fun getLinks(key: String): List<LinkItem>
}
