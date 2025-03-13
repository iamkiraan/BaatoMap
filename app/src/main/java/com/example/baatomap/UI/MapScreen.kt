package com.example.baatomap.UI

import android.graphics.drawable.Icon
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


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
            placeholder = { Text("Search places") },
            trailingIcon = {
                if(active){
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





        ) { }
    }

}

