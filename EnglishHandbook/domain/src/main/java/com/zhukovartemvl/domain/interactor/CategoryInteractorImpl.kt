package com.zhukovartemvl.domain.interactor

import com.zhukovartemvl.shared.interactor.CategoryInteractor
import com.zhukovartemvl.shared.model.*
import com.zhukovartemvl.shared.repository.DatabaseRepository


class CategoryInteractorImpl(private val repository: DatabaseRepository) : CategoryInteractor {

    private var parentId = 0
    private var backCategories = mutableListOf<BackItem>()

    override fun categoryBack(): List<Category> {
        return if (backCategories.isNotEmpty())
            categoryBack(backCategories.last())
        else
            listOf()
    }

    override fun categoryBack(backItem: BackItem): List<Category> {
        parentId = backItem.id

        for (id in backCategories.indexOf(backItem) until backCategories.size)
            if (id >= 0 && id < backCategories.size)
                backCategories.removeAt(id)

        return getCategories(backItem.title)
    }

    override fun openFolder(folder: Folder): List<Category> {
        val title =
            if (parentId == 0) "Главное меню"
            else folder.title
        backCategories.add(BackItem(parentId, title))
        parentId = folder.id

        return getCategories(folder.title)
    }

    override fun loadRootCategories(): List<Category> {
        parentId = 0
        backCategories.clear()
        return getCategories("")
    }

    override fun isRootFolder(): Boolean {
        return parentId == 0
    }

    private fun getCategories(headerTitle: String): List<Category> {
        val newCategoryList = mutableListOf<Category>()
        newCategoryList.addAll(backCategories)
        if (parentId != 0) newCategoryList.add(Header(headerTitle))
        newCategoryList.addAll(repository.getHierarchy(parentId).map { it.toCategory() })
        return newCategoryList
    }

    private fun HierarchyItem.toCategory(): Category {
        return when (type) {
            CategoryType.Folder.value -> Folder(id, key, text)
            CategoryType.Article.value -> Article(key, text)
            CategoryType.IrregularVerbs.value -> IrregularVerbs(key, text)
            CategoryType.Dictionary.value -> Dictionary(key, text)
            CategoryType.Links.value -> Links(key, text)
            else -> Title(key, text)
        }
    }
}
