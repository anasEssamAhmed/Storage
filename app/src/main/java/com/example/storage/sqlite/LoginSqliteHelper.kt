package com.example.storage.sqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class LoginSqliteHelper(context: Context) : SQLiteOpenHelper(context, Name, null, Version) {

    override fun onCreate(db: SQLiteDatabase?) {
        val query = "Create Table ${ConstantValue.Table_Name} (" +
                "${ConstantValue.ID} Integer Primary key AUTOINCREMENT, " +
                "${ConstantValue.Username} Text," +
                "${ConstantValue.Name} Text" +
                ")"
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun insertTable(name : String , username : String){
        val contentValue = ContentValues().apply {
            put(ConstantValue.Name , name)
            put(ConstantValue.Username , username)
        }
        this.writableDatabase.insert(ConstantValue.Table_Name,null , contentValue)
    }

    fun getData() {
       //  val cursor = this.readableDatabase.rawQuery("select * from ${ConstantValue.Table_Name} where ${ConstantValue.Name} = ?" , arrayOf("mohammed"))
        val columns = arrayOf(ConstantValue.ID,ConstantValue.Name,ConstantValue.Username)
        val selection = "${ConstantValue.Name} = ?"
        val selectionArgs = arrayOf("mohammed")
        val order = "${ConstantValue.ID} ASC"
        val cursor = this.readableDatabase.query(
            ConstantValue.Table_Name,
            columns,
            selection,
            selectionArgs,
            null,
            null,
            order
        )
        while (cursor.moveToNext()){
            val id = cursor.getInt(0)
            val username = cursor.getString(1)
            val name = cursor.getString(2)
            Log.d("aaas" , "$id + $username + $name")
        }
        cursor.close()
    }


    companion object {
        private const val Name = "Login Table"
        private const val Version = 1
    }

}