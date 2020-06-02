package com.zhukovartemvl.data.repository

import android.content.Context
import com.zhukovartemvl.data.converter.*
import com.zhukovartemvl.data.db.DatabaseLoader
import com.zhukovartemvl.shared.model.*
import com.zhukovartemvl.shared.repository.DatabaseRepository


class DatabaseRepositoryImpl(private val database: DatabaseLoader) : DatabaseRepository {

    override fun initDatabase(context: Context): Boolean {
        return database.init(context)
    }
    override fun updateAvailable(): Boolean {
        return database.updateAvailable()
    }
    override fun updateDatabase(context: Context): Boolean {
        return database.updateDatabase(context)
    }

    override fun getHierarchy(parentId: Int): List<HierarchyItem> {
        return database.instance.hierarchyDao().getAllChildren(parentId)
            .map { it.toHierarchyItem() }
    }

    override fun getDatabaseParameter(): DatabaseParametersItem {
        return database.instance.parameterDao().getParameters.toDatabaseParametersItem()
    }
    override fun getArticle(key: String): ArticleItem {
        return database.instance.articleDao().getByKey(key).toArticleItem()
    }
    override fun getDictionary(key: String): List<DictionaryItem> {
        return database.instance.dictionaryDao().getByKey(key).map { it.toDictionaryItem() }
    }
    override fun getVerbs(key: String): List<IrregularVerbItem> {
        return database.instance.verbDao().getByKey(key).map { it.toIrregularVerbItem() }
    }
    override fun getVerbs(): List<IrregularVerbItem> {
        return database.instance.verbDao().getAll().map { it.toIrregularVerbItem() }
    }
    override fun getLinks(key: String): List<LinkItem> {
        return database.instance.linkDao().getByKey(key).map { it.toLinkItem() }
    }
}
