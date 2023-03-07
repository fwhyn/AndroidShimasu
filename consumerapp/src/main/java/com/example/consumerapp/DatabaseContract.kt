package com.example.consumerapp

import android.net.Uri
import android.provider.BaseColumns


object DatabaseContract {
    private const val AUTHORITY = "com.example.contentprovider"
    private const val SCHEME = "content"

    class FavoriteUserColumn : BaseColumns {
        companion object {
            private const val TABLE_NAME = "favorite_table"
            const val ID = "id"
            const val USERNAME = "username"
            const val AVATAR_URL = "avatar_url"

            val MY_CONTENT_URI: Uri = Uri.Builder().scheme(SCHEME)
                .authority(AUTHORITY)
                .appendPath(TABLE_NAME)
                .build()
        }
    }
}