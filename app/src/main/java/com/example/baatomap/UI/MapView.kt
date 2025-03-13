    package com.example.baatomap.UI

    import android.util.Log
    import androidx.activity.ComponentActivity
    import androidx.compose.runtime.Composable
    import androidx.compose.ui.platform.LocalContext
    import androidx.compose.ui.viewinterop.AndroidView
    import org.maplibre.android.MapLibre
    import org.maplibre.android.WellKnownTileServer
    import org.maplibre.android.annotations.MarkerOptions
    import org.maplibre.android.camera.CameraPosition
    import org.maplibre.android.geometry.LatLng
    import androidx.compose.foundation.clickable
    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.foundation.layout.fillMaxWidth
    import androidx.compose.foundation.lazy.LazyColumn
    import androidx.compose.foundation.shape.RoundedCornerShape
    import androidx.compose.material.icons.Icons
    import androidx.compose.material.icons.rounded.Close
    import androidx.compose.material.icons.rounded.Search
    import androidx.compose.material3.Card
    import androidx.compose.material3.ExperimentalMaterial3Api
    import androidx.compose.material3.Icon
    import androidx.compose.material3.SearchBar
    import androidx.compose.material3.Text
    import androidx.compose.runtime.DisposableEffect
    import androidx.compose.runtime.LaunchedEffect
    import androidx.compose.runtime.getValue
    import androidx.compose.runtime.mutableStateOf
    import androidx.compose.runtime.remember
    import androidx.compose.runtime.setValue
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.unit.dp
    import com.example.baatomap.ApiWork.MapLifecycleObserver
    import com.example.baatomap.ApiWork.RetrofitObject.baatoSearchService
    import com.example.baatomap.DataClasses.SearchResult

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MapScreen() {
        val api_key = "bpk.qF1Ei9NBbPq-30XZOgl1uLocMkDiUEi9T4r59kGse07s"
        val context = LocalContext.current
        val mapView = remember { org.maplibre.android.maps.MapView(context) }
        val lifecycleObserver = remember { MapLifecycleObserver(mapView) }
        var cameraPosition by remember { mutableStateOf(CameraPosition.Builder().build()) }
        var markerPosition by remember { mutableStateOf<LatLng?>(null) }
        var searchResults by remember { mutableStateOf<List<SearchResult>>(emptyList()) }
        var query by remember { mutableStateOf("") }
        var active by remember { mutableStateOf(false) }
        var userLocation by remember { mutableStateOf<LatLng?>(null) }

        DisposableEffect(Unit) {
            val lifecycle = (context as ComponentActivity).lifecycle
            lifecycle.addObserver(lifecycleObserver)
            onDispose {
                lifecycle.removeObserver(lifecycleObserver)
            }
        }
        FetchUserLocation { latLng ->
            userLocation = latLng
            cameraPosition = CameraPosition.Builder()
                .target(latLng)
                .zoom(14.0)
                .build()
            markerPosition = latLng
        }

        LaunchedEffect(Unit) {
            mapView.getMapAsync { map ->
                map.setStyle("https://api.baato.io/api/v1/styles/breeze_cdn?key=${api_key}") {
                    map.uiSettings.setAttributionMargins(15, 0, 0, 15)
                    map.cameraPosition = cameraPosition
                    markerPosition?.let { position ->
                        map.addMarker(MarkerOptions().position(position))
                    }
                }
            }
        }

        Card {
            Column {
                SearchBar(
                    query = query,
                    onQueryChange = { query = it },
                    onSearch = { active = false },
                    active = active,
                    onActiveChange = { active = it },
                    placeholder = { Text("Search places") },
                    trailingIcon = {
                        if (active) {
                            Icon(
                                imageVector = Icons.Rounded.Close,
                                contentDescription = "close",
                                modifier = Modifier
                                    .clickable {
                                        active = false
                                    }
                            )
                        }
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Rounded.Search,
                            contentDescription = "Search icons"
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    // Perform search when the query changes
                    LaunchedEffect(query) {
                        if (query.isNotEmpty()) {
                            val response = baatoSearchService.SearchPalce(query, api_key)
                            searchResults = response.data
                        }
                    }

                    // Display search results
                    SearchResults(results = searchResults) { result ->

                        val latLng = LatLng(result.latitude, result.longitude)
                        cameraPosition = CameraPosition.Builder()
                            .target(latLng)
                            .zoom(14.0)
                            .build()
                        markerPosition = latLng
                        active = false

                    }

                }
                AndroidView(
                    factory = { mapView },
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }