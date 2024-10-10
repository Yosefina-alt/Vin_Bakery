package com.example.vinlokang

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.vinlokang.ui.theme.VinLokangTheme
import com.example.vinlokang.ui.theme.Artwork

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VinLokangTheme {
                VinLokangAppp()
            }
        }
    }
}

@SuppressLint("AutoboxingStateCreation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VinLokangAppp() {
    var currentArtworkIndex by remember { mutableStateOf(0) }
    val artworks = listOf(
        Artwork(R.drawable.vin1, "Danish Coklat Belepotan","VIN", "Rp.120.000.000"),
        Artwork(R.drawable.vin2, "Lapis Legit", "VIN", "Rp.120.000.000"),
        Artwork(R.drawable.vin3, "Lemon Cake", "VIN", "Rp.120.000.000"),
        Artwork(R.drawable.vin4, "Nastar Jambu", "VIN", "Rp.120.000.000"),
        Artwork(R.drawable.vin5, "Brownies Keju Kering", "VIN", "Rp.120.000.000"),
        Artwork(R.drawable.vin6, "Roti Bakso Sapia", "VIN", "Rp.120.000.000"),
        Artwork(R.drawable.vin7, "Donut Nut John", "VIN", "Rp.120.000.000")
        // Add more artworks here
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("VIN BAKERY")
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray)
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            ArtworkDisplay(artwork = artworks[currentArtworkIndex])

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(onClick = {
                    currentArtworkIndex = (currentArtworkIndex - 1 + artworks.size) % artworks.size
                }) {
                    Text("Previous")
                }

                Button(onClick = {
                    currentArtworkIndex = (currentArtworkIndex + 1) % artworks.size
                }) {
                    Text("Next")
                }
            }
        }
    }
}

@Composable
fun ArtworkDisplay(artwork: Artwork) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = artwork.imageResourceId),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = artwork.title,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Text(
            text = "by ${artwork.artist}",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center
        )

        Text(
            text = artwork.harga,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center
        )
    }
}
