package com.zhukovartemvl.home.navigation


interface HomeNavigation {
    fun openArticle(key: String, title: String)
    fun openDictionary(key: String, title: String)
    fun openLinks(key: String, title: String)
    fun openVerbs(key: String, title: String)
    fun openAbout()
}
