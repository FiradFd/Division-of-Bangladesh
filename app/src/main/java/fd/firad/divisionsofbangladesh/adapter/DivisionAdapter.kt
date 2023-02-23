package fd.firad.divisionsofbangladesh.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fd.firad.divisionsofbangladesh.DistrictActivity
import fd.firad.divisionsofbangladesh.databinding.DivisionItemBinding
import fd.firad.divisionsofbangladesh.model.Data

class DivisionAdapter(private val context: Context, private val list: List<Data>) :
    RecyclerView.Adapter<DivisionAdapter.MyViewHolder>() {
    class MyViewHolder(val binding: DivisionItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = DivisionItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val list = list[position]
        holder.binding.divisionItem = list

        holder.binding.root.setOnClickListener {
            val name = list.division
            val intent = Intent(context, DistrictActivity::class.java).apply {
                putExtra("name", name)
            }
            context.startActivity(intent)
        }
    }
}