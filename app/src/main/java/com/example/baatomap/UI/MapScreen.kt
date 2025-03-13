package com.example.baatomap.UI

import android.graphics.drawable.Icon
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun MapScreen(){
    var query by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }
    Card {
        SearchBar(
            query = query,
            onQueryChange = {query = it},
            onSearch = { active = false },
            active = active,

            onActiveChange = {active = it},
            placeholder = { Text("Search") },
            leadingIcon = {
                Icon(


                )
            }




        ) { }
    }

}