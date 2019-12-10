package test.cendana.wiliarko.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_splashscreen.*
import test.cendana.wiliarko.R
import test.cendana.wiliarko.data.model.UserDBModel
import test.cendana.wiliarko.di.Injection
import test.cendana.wiliarko.ui.home.MainActivity
import test.cendana.wiliarko.ui.viewmodel.ViewModelFactory

class Splashscreen : AppCompatActivity() {
    private lateinit var viewModel: SplashcreenViewmodel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        txt_progres.text = "Initialize App"

        initData()
    }

    private fun obtainViewModel(activity: Splashscreen): SplashcreenViewmodel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProviders.of(activity, factory).get(SplashcreenViewmodel::class.java)
    }

    fun initData(){
        viewModel = obtainViewModel(this)
        viewModel.getUser().observe(this, Observer {
            txt_progres.text = "Initialize Data"
            for (i in it){
                var usertmp = UserDBModel()
                usertmp.id = Integer.parseInt(i.id.toString())
                usertmp.name = i.name
                usertmp.username = i.username
                usertmp.email = i.email
                usertmp.street = i.address?.street
                usertmp.suite = i.address?.suite
                usertmp.city = i.address?.city
                usertmp.zipcode = i.address?.zipcode
                usertmp.lat = i.address?.geo?.lat
                usertmp.lng = i.address?.geo?.lng
                viewModel.saveUser(usertmp)

                txt_progres.text = "Data saved with name "+i.name
            }

            txt_progres.text = "Finish"

            val moveIntent = Intent(this, MainActivity::class.java)
            startActivity(moveIntent)
            finish()
        })
    }
}
