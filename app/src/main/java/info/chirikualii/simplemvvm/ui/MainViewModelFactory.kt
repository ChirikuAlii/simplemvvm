package info.chirikualii.simplemvvm.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import info.chirikualii.simplemvvm.data.repository.HeadlineRepo


/**
 * Created by chirikuAlii on 12/07/2020.
 * github.com/chirikualii
 */

class MainViewModelFactory : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(HeadlineRepo()) as T
    }

}