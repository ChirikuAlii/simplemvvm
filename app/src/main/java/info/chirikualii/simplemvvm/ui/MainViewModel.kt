package info.chirikualii.simplemvvm.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import info.chirikualii.simplemvvm.data.local.ArticleEntity
import info.chirikualii.simplemvvm.data.repository.HeadlineRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


/**
 * Created by chirikuAlii on 12/07/2020.
 * github.com/chirikualii
 */

class MainViewModel(private val repo: HeadlineRepo) : ViewModel(){

    private val TAG = MainViewModel::class.java.simpleName
    private val _listArticle =MutableLiveData<List<ArticleEntity>>()
    val listArticle :LiveData<List<ArticleEntity>> get() = _listArticle

    fun doLoadHeadline(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                Log.d(TAG,"do load headline")
                val result = repo.getHeadlineNewsRemote().let { repo.getHeadlineNewsLocal() }

                _listArticle.postValue(result)

                Log.d(TAG,"success load headline ${Gson().toJsonTree(result)}")
            }catch (e:Throwable){
                Log.e(TAG,"error load headline exception ${e.message}")
            }
        }
    }
}