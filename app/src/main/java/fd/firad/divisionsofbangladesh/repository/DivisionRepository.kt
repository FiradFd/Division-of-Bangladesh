package fd.firad.divisionsofbangladesh.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import fd.firad.divisionsofbangladesh.api.ApiService.apiService
import fd.firad.divisionsofbangladesh.model.MainDistrictModel
import fd.firad.divisionsofbangladesh.model.MainResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DivisionRepository {
    private var divisionList = MutableLiveData<MainResponse>()
    val divisions: LiveData<MainResponse>
        get() = divisionList

    private var districtList = MutableLiveData<MainDistrictModel>()
    val district: LiveData<MainDistrictModel>
        get() = districtList

    fun getDivision() {
        apiService.getDivisions().enqueue(object : Callback<MainResponse?> {
            override fun onResponse(call: Call<MainResponse?>, response: Response<MainResponse?>) {

                divisionList.postValue(response.body())
            }

            override fun onFailure(call: Call<MainResponse?>, t: Throwable) {
            }
        })
    }

    fun getDistrict(name: String) {
        apiService.getDistricts(name).enqueue(object : Callback<MainDistrictModel?> {
            override fun onResponse(
                call: Call<MainDistrictModel?>,
                response: Response<MainDistrictModel?>
            ) {
                districtList.postValue(response.body())
            }

            override fun onFailure(call: Call<MainDistrictModel?>, t: Throwable) {
            }
        })
    }

}


