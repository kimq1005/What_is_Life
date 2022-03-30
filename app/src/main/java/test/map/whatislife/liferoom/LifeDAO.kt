package test.map.whatislife.liferoom

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import retrofit2.http.DELETE

@Dao
interface LifeDAO {

    @Insert(onConflict = REPLACE)
    fun lifeInsert(lifeEntity: LifeEntity)

    @Query("SELECT * FROM lifeEntity")
    fun lifegetAll() : LiveData<List<LifeEntity>>

    @Delete
    fun lifeDelete(lifeEntity: LifeEntity)
}