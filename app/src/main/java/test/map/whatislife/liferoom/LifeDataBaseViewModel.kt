package test.map.whatislife.liferoom

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LifeDataBaseViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = LifeRepository(application)

    class Factory(val application: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return LifeDataBaseViewModel(application) as T
        }
    }

    fun lifeinsert(
        lifetitle: String?,
        lifeContent: String,
        Time: String?,
    ) {
        val lifeEntity = LifeEntity(
            null, lifetitle, lifeContent, Time
        )

        CoroutineScope(Dispatchers.IO).launch {
            repository.lifeinsert(lifeEntity)
        }

    }


    fun lifegetAll(): LiveData<List<LifeEntity>> {
        return repository.lifegetAll()
    }

    fun lifedelete(lifeentity: LifeEntity) {

        CoroutineScope(Dispatchers.IO).launch {
            repository.lifedelete(lifeentity)
        }
    }


}