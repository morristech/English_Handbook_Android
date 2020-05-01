package com.zhukovartemvl.shared.interactor

import com.zhukovartemvl.shared.model.LinkItem


interface LinksInteractor {

    fun getLinks(key: String): List<LinkItem>

}
