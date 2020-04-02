package com.zhukovartemvl.shared.repository

import com.zhukovartemvl.data.db.entity.HierarchyEntity


interface DatabaseRepository {

    fun getHierarchy(parentId: Int): List<HierarchyEntity>

}
