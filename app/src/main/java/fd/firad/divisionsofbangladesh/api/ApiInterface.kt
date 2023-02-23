package fd.firad.divisionsofbangladesh.api

import fd.firad.divisionsofbangladesh.model.MainDistrictModel
import fd.firad.divisionsofbangladesh.model.MainResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("api/v1.1/divisions")
    fun getDivisions(): Call<MainResponse>

    @GET("api/v1.1/division/{name}")
    fun getDistricts(@Path("name") name: String): Call<MainDistrictModel>
}