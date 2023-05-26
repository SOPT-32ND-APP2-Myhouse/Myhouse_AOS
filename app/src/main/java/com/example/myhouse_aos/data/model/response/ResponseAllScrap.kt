package com.example.myhouse_aos.data.model.response

import com.example.myhouse_aos.domain.model.Folder
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseScrap(
    val data: Data,
    val message: String,
    val status: Int,
    val success: Boolean,
) {
    @Serializable
    data class Data(
        @SerialName("scrap_folders")
        val scrapFolders: List<ScrapFolder>,
    ) {
        @Serializable
        data class ScrapFolder(
            @SerialName("folder_id")
            val folderId: Int,
            @SerialName("folder_title")
            val folderTitle: String,
            val scraps: List<Scrap>,
        ) {
            @Serializable
            data class Scrap(
                @SerialName("image_url")
                val imageUrl: String?,
                @SerialName("scrap_id")
                val scrapId: Int,
            )

            fun toScrap() = scraps.map { scrap ->
                com.example.myhouse_aos.domain.model.Scrap(
                    scrapId = scrap.scrapId,
                    imageUrl = scrap.imageUrl
                )
            }
        }

        fun toFolder() = scrapFolders.map { folder ->
            Folder(
                folderId = folder.folderId,
                folderTitle = folder.folderTitle,
                scraps = folder.toScrap()
            )
        }
    }
}