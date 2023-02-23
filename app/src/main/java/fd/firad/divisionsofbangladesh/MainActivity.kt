package fd.firad.divisionsofbangladesh

import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import fd.firad.divisionsofbangladesh.adapter.DivisionAdapter
import fd.firad.divisionsofbangladesh.databinding.ActivityMainBinding
import fd.firad.divisionsofbangladesh.repository.DivisionRepository
import fd.firad.divisionsofbangladesh.viewmodel.DivisionViewModel
import fd.firad.divisionsofbangladesh.viewmodel.DivisionViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: DivisionViewModel
    private lateinit var factory: DivisionViewModelFactory
    private lateinit var repository: DivisionRepository
    private lateinit var divAdapter: DivisionAdapter
    private lateinit var dialog: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)


        dialog = ProgressDialog(this@MainActivity)
        dialog.apply {
            setTitle("Loading")
            setMessage("please wait a few seconds")
            show()
        }


        repository = DivisionRepository()
        factory = DivisionViewModelFactory(repository)
        viewModel = ViewModelProvider(this@MainActivity, factory)[DivisionViewModel::class.java]
        viewModel.getDivisions()

        viewModel.division.observe(this@MainActivity, Observer {
            dialog.dismiss()
            divAdapter = DivisionAdapter(this@MainActivity, it.data)
            binding.recycleId.apply {
                adapter = divAdapter
                layoutManager = LinearLayoutManager(this@MainActivity)
            }

        })


    }
}