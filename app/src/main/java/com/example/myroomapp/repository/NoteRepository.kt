package com.example.myroomapp.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.myroomapp.database.Note
import com.example.myroomapp.database.NoteDao
import com.example.myroomapp.database.NoteRoomDatabase
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class NoteRepository(application: Application) {
    private val mNotesDao: NoteDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = NoteRoomDatabase.getDatabase(application)
        mNotesDao = db.NoteDao()
    }

    fun getAllNotes(): LiveData<List<Note>> = mNotesDao.getAllNotes()

    fun insert(note: Note){
        executorService.execute { mNotesDao.insert(note)}
    }

    fun delete(note: Note){
        executorService.execute { mNotesDao.delete(note)}
    }

    fun update(note: Note){
        executorService.execute { mNotesDao.update(note)}
    }
}