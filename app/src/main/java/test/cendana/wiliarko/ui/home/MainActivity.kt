package test.cendana.wiliarko.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import test.cendana.wiliarko.R
import test.cendana.wiliarko.data.model.UserDBModel
import test.cendana.wiliarko.ui.detail.DetailActivity

class MainActivity : AppCompatActivity() {

    internal var dataList: MutableList<UserDBModel> = mutableListOf()
    internal lateinit var adapter: MainActivityAdapter

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

    fun initData(){
        val model = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(MainActivityViewmodel::class.java)

        model.getUser().observe(this, Observer {
            dataList.clear()
            dataList.addAll(it)
            adapter.notifyDataSetChanged()
        })
    }
}
