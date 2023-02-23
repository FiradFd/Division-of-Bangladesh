package fd.firad.divisionsofbangladesh.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import fd.firad.divisionsofbangladesh.repository.DivisionRepository

class DivisionViewModelFactory(val repository: DivisionRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DivisionViewModel(repository) as T
    }
}