package test.cendana.wiliarko.ui.home

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.*
import androidx.cardview.widget.CardView
import test.cendana.wiliarko.R
import test.cendana.wiliarko.data.model.UserDBModel


class MainActivityAdapter(private val datas: List<UserDBModel>, private val listener: (UserDBModel) -> Unit)
    : RecyclerView.Adapter<MainAcitivtyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAcitivtyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.user_item, parent, false)

        return MainAcitivtyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MainAcitivtyViewHolder, position: Int) {
        holder.bindItem(datas[position],listener,position)
    }

    override fun getItemCount(): Int = datas.size

}

class MainAcitivtyViewHolder(view: View) : RecyclerView.ViewHolder(view){
    private val cv: CardView = view.findViewById(R.id.cv)
    private val name: TextView = view.findViewById(R.id.name)

    fun bindItem(data: UserDBModel, listener: (UserDBModel) -> Unit, position: Int) {
        name.text = data.name

        cv.setOnClickListener {
            listener(data)
        }
    }

}