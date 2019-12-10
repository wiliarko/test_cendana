package test.cendana.wiliarko.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*
import test.cendana.wiliarko.R
import test.cendana.wiliarko.data.model.UserDBModel

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val user = intent.getParcelableExtra("user") as UserDBModel

        name.text = user.name

    }
}
