package test.cendana.wiliarko.ui.detail

import android.location.Location
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.annotations.MarkerOptions
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.Style
import kotlinx.android.synthetic.main.activity_detail.*
import test.cendana.wiliarko.R
import test.cendana.wiliarko.data.model.UserDBModel

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Mapbox.getInstance(
            this,
            getString(R.string.access_token)
        )
        
        setContentView(R.layout.activity_detail)

        val user = intent.getParcelableExtra("user") as UserDBModel

        name.text = user.name
        username.text = user.username
        email.text = user.email
        address.text = user.street+" " +user.suite+" "+user.city+" "+user.zipcode

        mapview.onCreate(savedInstanceState)
        mapview.getMapAsync { map ->
            map.setStyle(Style.MAPBOX_STREETS) {

            }
            map.moveCamera(
                CameraUpdateFactory.newLatLngZoom(LatLng(user.lat.toString().toDouble(), user.lng.toString().toDouble()), 12.0)
            )
            map.addMarker(MarkerOptions()
                .position(LatLng(user.lat.toString().toDouble(), user.lng.toString().toDouble()))
                .title(user.name))
        }

    }

   override fun onStart() {
        super.onStart()
       mapview.onStart()
    }

    override fun onResume() {
        super.onResume()
        mapview.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapview.onPause()
    }

    override fun onStop() {
        super.onStop()
        mapview.onStop()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapview.onLowMemory()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapview.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        mapview.onSaveInstanceState(outState)
    }
}
