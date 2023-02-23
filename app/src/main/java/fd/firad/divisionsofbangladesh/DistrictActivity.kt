package fd.firad.divisionsofbangladesh

import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import fd.firad.divisionsofbangladesh.adapter.DistrictAdapter
import fd.firad.divisionsofbangladesh.databinding.ActivityDistrictBinding
import fd.firad.divisionsofbangladesh.repository.DivisionRepository
import fd.firad.divisionsofbangladesh.viewmodel.DivisionViewModel
import fd.firad.divisionsofbangladesh.viewmodel.DivisionViewModelFactory

class DistrictActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDistrictBinding
    private lateinit var viewModel: DivisionViewModel
    private lateinit var factory: DivisionViewModelFactory
    private lateinit var repository: DivisionRepository
    private lateinit var disAdapter: DistrictAdapter
    private lateinit var dialog: ProgressDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@DistrictActivity, R.layout.activity_district)

        val name = intent.getStringExtra("name")

        supportActionBar?.title = "Districts of $name"

        dialog = ProgressDialog(this@DistrictActivity)
        dialog.apply {
            setTitle("Loading")
            setMessage("please wait a few seconds")
            show()
        }

        repository = DivisionRepository()
        factory = DivisionViewModelFactory(repository)
        viewModel = ViewModelProvider(this@DistrictActivity, factory)[DivisionViewModel::class.java]
        viewModel.getDistrict(name!!)

        viewModel.district.observe(this@DistrictActivity, Observer {
            dialog.dismiss()
            disAdapter = DistrictAdapter(this@DistrictActivity, it.data)
            binding.districtRecycle.apply {
                adapter = disAdapter
                layoutManager = LinearLayoutManager(this@DistrictActivity)
            }

        })
    }
}