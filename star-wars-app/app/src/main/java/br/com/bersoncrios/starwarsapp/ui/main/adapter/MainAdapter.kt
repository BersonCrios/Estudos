package br.com.bersoncrios.starwarsapp.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.bersoncrios.starwarsapp.R
import br.com.bersoncrios.starwarsapp.data.model.Result
import kotlinx.android.synthetic.main.peopleitem.view.*

class MainAdapter(private val results: ArrayList<Result>):
    RecyclerView.Adapter<MainAdapter.DataViewHolder>() {
    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(result: Result) {
            itemView.apply {
                tv_name.text = result.name
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.peopleitem, parent, false))


    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(results[position])
    }

    override fun getItemCount(): Int = results.size

    fun addPeoples(results: List<Result>){
        this.results.apply {
            clear()
            addAll(results)
        }
    }
}
