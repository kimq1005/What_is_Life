package test.map.whatislife.liferoom

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lifeEntity")
data class LifeEntity(
    @PrimaryKey(autoGenerate = true)
    var id :Long?,

    var lifeTitle : String?,
    var lifeContent : String,
    var Time:String?
)