package fd.firad.divisionsofbangladesh.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fd.firad.divisionsofbangladesh.model.MainDistrictModel
import fd.firad.divisionsofbangladesh.model.MainResponse
import fd.firad.divisionsofbangladesh.repository.DivisionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DivisionViewModel(private val repository: DivisionRepository) : ViewModel() {

    val division: LiveData<MainResponse>
        get() = repository.divisions

    fun getDivisions() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getDivision()
        }
    }


    fun getDistrict(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getDistrict(name)
        }
    }

    val district: LiveData<MainDistrictModel>
        get() = repository.district

}