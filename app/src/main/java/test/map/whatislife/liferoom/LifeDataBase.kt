package test.map.whatislife.liferoom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [LifeEntity::class], version = 1)
abstract class LifeDataBase : RoomDatabase() {
    abstract fun lifeDao(): LifeDAO

    companion object {
        private var INSTANCE: LifeDataBase? = null

        fun getinstance(context: Context): LifeDataBase? {
            if (INSTANCE == null) {
                synchronized(LifeDataBase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        LifeDataBase::class.java,
                        "life.db"
                    )

                        .fallbackToDestructiveMigration()
                        .build()
                }
            }

            return INSTANCE
        }
    }
}