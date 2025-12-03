package com.ostapkhomiak.weatherapp.ui.screens.settings


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        var cityName by remember { mutableStateOf("") }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(Color(0x1A000000))
                .padding(8.dp)
        ) {
            Column {
                Text("City name")

                Row(modifier = Modifier.height(IntrinsicSize.Min)) {
                    TextField(
                        value = cityName,
                        onValueChange = { cityName = it },
                        modifier = Modifier
                            .fillMaxHeight()
                            .clip(RoundedCornerShape(20.dp))
                            .weight(4f)

                    )

                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .aspectRatio(1f)
                    ) {
                        Text("OK")
                    }
                }


            }

        }


    }
}

