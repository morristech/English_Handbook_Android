package com.zhukovartemvl.shared.interactor

import com.zhukovartemvl.shared.model.BackItem
import com.zhukovartemvl.shared.model.Category
import com.zhukovartemvl.shared.model.Folder


interface CategoryInteractor {

    fun categoryBack(): List<Category>
    fun categoryBack(backItem: BackItem): List<Category>
    fun openFolder(folder: Folder): List<Category>
    fun loadRootCategories(): List<Category>
    fun isRootFolder(): Boolean

}
