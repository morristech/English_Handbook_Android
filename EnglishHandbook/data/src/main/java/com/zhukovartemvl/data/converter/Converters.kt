package com.zhukovartemvl.data.converter

import com.zhukovartemvl.data.db.entity.*
import com.zhukovartemvl.shared.model.*


fun ArticleEntity.toArticleItem(): ArticleItem {
    return ArticleItem(text)
}

fun DatabaseParametersEntity.toDatabaseParametersItem(): DatabaseParametersItem {
    return DatabaseParametersItem(version, lastUpdate, updateNote)
}

fun DictionaryEntity.toDictionaryItem(): DictionaryItem {
    return DictionaryItem(text, translation)
}

fun HierarchyEntity.toHierarchyItem(): HierarchyItem {
    return HierarchyItem(id, parentId, key, type, text)
}

fun IrregularVerbEntity.toIrregularVerbItem(): IrregularVerbItem {
    return IrregularVerbItem(type, rate, firstForm, secondForm, thirdForm, translation)
}

fun LinkEntity.toLinkItem(): LinkItem {
    return LinkItem(link, text)
}
