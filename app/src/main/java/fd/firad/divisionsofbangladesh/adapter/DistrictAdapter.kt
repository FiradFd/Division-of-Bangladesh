package fd.firad.divisionsofbangladesh.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fd.firad.divisionsofbangladesh.databinding.DistrictItemBinding
import fd.firad.divisionsofbangladesh.model.DataX

class DistrictAdapter(private val context: Context, private val list: List<DataX>) :
    RecyclerView.Adapter<DistrictAdapter.MyDisViewHolder>() {
    private var posi: Int? = null

    class MyDisViewHolder(val binding: DistrictItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyDisViewHolder {
        val view = DistrictItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyDisViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(
        holder: MyDisViewHolder,
        @SuppressLint("RecyclerView") position: Int
    ) {
        val data = list.get(position)

        holder.binding.districtItem = data

    }
}