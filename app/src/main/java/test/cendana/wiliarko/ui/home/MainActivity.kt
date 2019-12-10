package test.cendana.wiliarko.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import test.cendana.wiliarko.R
import test.cendana.wiliarko.data.model.UserDBModel
import test.cendana.wiliarko.ui.detail.DetailActivity
import test.cendana.wiliarko.ui.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {

    internal var dataList: MutableList<UserDBModel> = mutableListOf()
    internal lateinit var adapter: MainActivityAdapter

    private lateinit var viewModel: MainActivityViewmodel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = MainActivityAdapter(dataList) {
            val moveIntent = Intent(this, DetailActivity::class.java)
            moveIntent.putExtra("user",it)
            startActivity(moveIntent)
        }
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = adapter

        initData()
    }

    private fun obtainViewModel(activity: MainActivity): MainActivityViewmodel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProviders.of(activity, factory).get(MainActivityViewmodel::class.java)
    }


    fun initData(){
        viewModel = obtainViewModel(this)

        viewModel.getUser().observe(this, Observer {
            dataList.clear()
            dataList.addAll(it)
            adapter.notifyDataSetChanged()
        })
    }

    override fun onBackPressed() {

        val builder = AlertDialog.Builder(this@MainActivity)
        builder.setTitle("Pertanyaan")
        builder.setMessage("Yakin mau tutup aplikasinya ?")

        builder.setPositiveButton("YES"){dialog, which ->
            finish()
        }

        builder.setNeutralButton("Cancel"){_,_ ->

        }

        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}
