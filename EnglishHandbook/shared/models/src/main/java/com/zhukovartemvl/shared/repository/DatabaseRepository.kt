package com.zhukovartemvl.shared.repository

import com.zhukovartemvl.shared.model.*


interface DatabaseRepository {

    fun getHierarchy(parentId: Int): List<HierarchyItem>
    fun getDatabaseParameter(): DatabaseParametersItem
    fun getArticle(key: String): ArticleItem
    fun getDictionary(key: String): List<DictionaryItem>
    fun getVerbs(key: String): List<IrregularVerbItem>
    fun getLinks(key: String): List<LinkItem>

}
