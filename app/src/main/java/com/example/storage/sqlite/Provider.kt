package com.example.storage.sqlite

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri

class Provider : ContentProvider() {
    private lateinit var db: LoginSqliteHelper
    override fun onCreate(): Boolean {
        db = LoginSqliteHelper(context!!)
        return true
    }

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? {
        return db.readableDatabase.query(
            ConstantValue.Table_Name,
            projection,
            selection,
            selectionArgs,
            null,
            null,
            sortOrder
        )
    }

    override fun getType(uri: Uri): String? {
        return "vnd.android.cursor.dir/vnd.example.storge.provider"
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        TODO("Not yet implemented")
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        TODO("Not yet implemented")
    }

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ): Int {
        TODO("Not yet implemented")
    }
}