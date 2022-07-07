package kr.example.jetnote.screens.note2.data

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import kotlinx.coroutines.flow.Flow
import kr.example.jetnote.screens.note2.model.Note


@Dao
interface NoteDatabaseDao {

    @Query("select * from notes_tbl")
    fun getNotes(): Flow<List<Note>>

    @Query("select * from notes_tbl where id=:id")
    suspend  fun getOneNote(id: String): Note

    @Insert(onConflict = REPLACE)
    suspend  fun insert(note: Note)

    @Update(onConflict = REPLACE)
    suspend  fun update(note: Note)

    @Delete
    suspend  fun delete(note: Note)

    @Query("delete from notes_tbl")
    suspend fun deleteAll()



}