package com.zhukovartemvl.home.navigation


interface HomeNavigation {
    fun openArticle(key: String)
    fun openDictionary(key: String)
    fun openLinks(key: String)
    fun openVerbs(key: String)
    fun openAbout()
}
