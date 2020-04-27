package com.zhukovartemvl.data.repository

import com.zhukovartemvl.data.db.DatabaseLoaderImpl
import com.zhukovartemvl.shared.model.*
import com.zhukovartemvl.shared.repository.DatabaseRepository


class DatabaseRepositoryImpl(private val databaseLoader: DatabaseLoaderImpl) : DatabaseRepository {

    override fun getHierarchy(parentId: Int): List<HierarchyItem> {
        TODO("Not yet implemented")
    }

    override fun getDatabaseParameter(): DatabaseParametersItem {
        val parameters = databaseLoader.instance.parameterDao().getParameters
        return DatabaseParametersItem(
            parameters.version,
            parameters.lastUpdate,
            parameters.updateNote
        )
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
