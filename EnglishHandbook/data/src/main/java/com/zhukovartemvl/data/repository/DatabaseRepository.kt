package com.zhukovartemvl.data.repository

import com.zhukovartemvl.shared.model.*
import com.zhukovartemvl.shared.repository.DatabaseRepository


class DatabaseRepositoryImpl: DatabaseRepository {

    override fun getHierarchy(parentId: Int): List<HierarchyItem> {
        TODO("Not yet implemented")
    }

    override fun getDatabaseParameter(): DatabaseParametersItem {
        TODO("Not yet implemented")
    }

    override fun getArticle(key: String): ArticleItem {
        TODO("Not yet implemented")
    }

    override fun getDictionary(key: String): List<DictionaryItem> {
        TODO("Not yet implemented")
    }

    override fun getVerbs(key: String): List<IrregularVerbItem> {
        TODO("Not yet implemented")
    }

    override fun getLinks(key: String): List<LinkItem> {
        TODO("Not yet implemented")
    }

}
