    package com.example.baatomap.UI

    import android.util.Log
    import androidx.compose.runtime.Composable
    import androidx.compose.ui.platform.LocalContext
    import androidx.compose.ui.viewinterop.AndroidView
    import org.maplibre.android.MapLibre
    import org.maplibre.android.WellKnownTileServer
    import org.maplibre.android.camera.CameraPosition
    import org.maplibre.android.geometry.LatLng

    @Composable
    fun MapView() {
        val myApiKey = "bpk.qF1Ei9NBbPq-30XZOgl1uLocMkDiUEi9T4r59kGse07s"
        val context = LocalContext.current

        AndroidView(
            factory = { context ->
                // Initialize MapLibre
                MapLibre.getInstance(context, myApiKey, WellKnownTileServer.MapLibre)
                Log.d("MapView", "MapLibre initialized")

                // Create a MapView
                val mapView = org.maplibre.android.maps.MapView(context)

                // Set the map style URL (e.g., Baato's style)
                val styleUrl = "https://api.baato.io/api/v1/styles/breeze_cdn?key=${myApiKey}"

                // Initialize the map
                mapView.onCreate(null)
                mapView.getMapAsync { map ->
                    map.setStyle(styleUrl) {
                        // Configure map UI settings
                        map.uiSettings.setAttributionMargins(15, 0, 0, 15)

                        // Set the initial camera position
                        map.cameraPosition = CameraPosition.Builder()
                            .target(LatLng(27.700769, 85.300140)) // Set the center of the map
                            .zoom(10.0) // Set the zoom level
                            .bearing(2.0) // Set the bearing (rotation)
                            .build()
                    }
                }

                // Return the MapView
                mapView
            },
            update = { mapView ->
                // Update logic (if needed)
            }
        )
    }