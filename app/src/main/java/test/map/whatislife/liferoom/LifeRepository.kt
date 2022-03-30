package test.map.whatislife.liferoom

import android.app.Application
import androidx.lifecycle.LiveData

class LifeRepository(application: Application) {

    private val lifeDAO : LifeDAO
    private val lifeEntity : LiveData<List<LifeEntity>>

    init {
        val lifeDataBase = LifeDataBase.getinstance(application)!!
        lifeDAO = lifeDataBase.lifeDao()
        lifeEntity = lifeDataBase.lifeDao().lifegetAll()
    }


    fun lifeinsert(lifeEntity: LifeEntity){
        lifeDAO.lifeInsert(lifeEntity)
    }

    fun lifegetAll() : LiveData<List<LifeEntity>>{
        return lifeDAO.lifegetAll()
    }

    fun lifedelete(lifeEntity: LifeEntity){
        lifeDAO.lifeDelete(lifeEntity)
    }
}