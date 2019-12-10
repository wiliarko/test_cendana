package test.cendana.wiliarko.ui.detail

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback
import com.mapbox.mapboxsdk.maps.Style
import com.mapbox.mapboxsdk.maps.Style.OnStyleLoaded
import kotlinx.android.synthetic.main.activity_detail.*
import test.cendana.wiliarko.R
import test.cendana.wiliarko.data.model.UserDBModel


class DetailActivity : AppCompatActivity() {

    private var mapView: MapView? = null

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

        mapView?.onCreate(savedInstanceState)
        mapView?.getMapAsync { map ->
            map.setStyle(Style.OUTDOORS) { style ->

            }
            map.moveCamera(
                CameraUpdateFactory.newLatLngZoom(LatLng(-32.557013, -56.149056), 4.0)
            )
        }

    }

    override fun onStart() {
        super.onStart()
        mapView?.onStart()
    }

    override fun onResume() {
        super.onResume()
        mapView?.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView?.onPause()
    }

    override fun onStop() {
        super.onStop()
        mapView?.onStop()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView?.onLowMemory()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView?.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        mapView?.onSaveInstanceState(outState)
    }
}
