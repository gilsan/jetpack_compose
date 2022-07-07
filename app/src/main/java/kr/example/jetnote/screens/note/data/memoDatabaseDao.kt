package kr.example.jetnote.screens.note.data

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import kotlinx.coroutines.flow.Flow
import kr.example.jetnote.screens.note.model.Memo


@Dao
interface MemoDatabaseDao {

    @Query("select * from memo_tbl")
    fun getNotes(): Flow<List<Memo>>

    @Query("select * from memo_tbl where id=:id")
    suspend  fun getOneNote(id: String): Memo

    @Insert(onConflict = REPLACE)
    suspend  fun insert(note: Memo)

    @Update(onConflict = REPLACE)
    suspend  fun update(note: Memo)

    @Delete
    suspend  fun delete(note: Memo)

    @Query("delete from memo_tbl")
    suspend fun deleteAll()




}