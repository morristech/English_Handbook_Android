package com.zhukovartemvl.shared.model


data class DatabaseInfo(
    val dbName: String,
    val zipName: String,
    val path: String,
    val link: String,
    val versionLink: String,
    val password: String
)
