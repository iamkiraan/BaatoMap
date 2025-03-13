package com.example.baatomap.ApiWork

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

class MapLifecycleObserver(private val mapView: org.maplibre.android.maps.MapView) :
    DefaultLifecycleObserver {
    override fun onCreate(owner: LifecycleOwner) {
        mapView.onCreate(null)
    }

    override fun onStart(owner: LifecycleOwner) {
        mapView.onStart()
    }

    override fun onResume(owner: LifecycleOwner) {
        mapView.onResume()
    }

    override fun onPause(owner: LifecycleOwner) {
        mapView.onPause()
    }

    override fun onStop(owner: LifecycleOwner) {
        mapView.onStop()
    }

    override fun onDestroy(owner: LifecycleOwner) {
        mapView.onDestroy()
    }
}