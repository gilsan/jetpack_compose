package kr.example.jetnote.screens.note2.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import kr.example.jetnote.screens.note2.data.NoteDatabaseDao
import kr.example.jetnote.screens.note2.model.Note
import javax.inject.Inject

class RepositoryDao @Inject constructor(private val noteDatabaseDao: NoteDatabaseDao) {

    suspend fun addNote(note: Note) = noteDatabaseDao.insert(note)
    suspend fun updateNote(note: Note) = noteDatabaseDao.update(note)
    suspend fun  deleteNote(note: Note) = noteDatabaseDao.delete(note)
    suspend fun deleteAll()= noteDatabaseDao.deleteAll()
    fun getAllNote(): Flow<List<Note>> = noteDatabaseDao.getNotes().flowOn(Dispatchers.IO).conflate()
}