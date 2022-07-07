package kr.example.jetnote.screens.note.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import kr.example.jetnote.screens.note.data.MemoDatabaseDao
import kr.example.jetnote.screens.note.model.Memo
import javax.inject.Inject

class Repository @Inject constructor( private  val memoDatabaseDao: MemoDatabaseDao) {
    suspend fun  addNote(memo: Memo) = memoDatabaseDao.insert(note = memo)
    suspend fun  updateNote(memo: Memo) = memoDatabaseDao.update(note = memo)
    suspend fun  deleteNote(memo: Memo) = memoDatabaseDao.delete(memo)
    suspend fun  deleteAll() = memoDatabaseDao.deleteAll()
    fun getAllMemo(): Flow<List<Memo>> = memoDatabaseDao.getNotes().flowOn(Dispatchers.IO).conflate()

}