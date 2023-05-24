package com.example.myhouse_aos.domain.model


data class Folder(
    val folderId: Int,
    val folderTitle: String,
    val scraps: List<Scrap>,
)

data class Scrap(
    val imageUrl: String,
    val scrapId: Int,
)
