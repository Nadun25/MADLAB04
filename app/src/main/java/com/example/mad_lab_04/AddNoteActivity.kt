package com.example.mad_lab_04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mad_lab_04.databinding.ActivityAddNewBinding
import com.example.mad_lab_04.databinding.ActivityMainBinding
import com.example.notessqlite.NotesDatabaseHelper


class AddNoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddNewBinding
    private lateinit var db: NotesDatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NotesDatabaseHelper(this)

        binding.saveButton.setOnClickListener{
            val title = binding.titleEditText.text.toString()
            val content = binding.contentEditText.text.toString()
            val note = Note(0,title,content)
            db.insertNote(note)
            finish()
            Toast.makeText(this,"Note Saved",Toast.LENGTH_SHORT).show()

        }
    }
}