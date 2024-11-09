package com.example.storage.sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.storage.databinding.ActivitySqliteBinding

class Sqlite : AppCompatActivity() {
    private lateinit var binding: ActivitySqliteBinding
    private val db = LoginSqliteHelper(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySqliteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.saveButtonToSqlite.setOnClickListener {
            insertData()
            db.getData()
        }
        db.getData()
    }


    private fun insertData() {
        db.insertTable(
            binding.textInputNameSqlite.text.toString(),
            binding.textInputUsernameSqlite.text.toString()
        )
    }
}