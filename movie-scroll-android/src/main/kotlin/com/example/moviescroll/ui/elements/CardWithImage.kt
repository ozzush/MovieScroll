package com.example.moviescroll.ui.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter

@Composable
fun CardWithImage(imageUrl: String?, imageDescription: String?, content: @Composable () -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            if (imageUrl != null) {
                Image(
                    painter = rememberAsyncImagePainter(model = imageUrl),
                    contentDescription = imageDescription,
                    modifier = Modifier.size(80.dp),
                    contentScale = ContentScale.FillBounds
                )
            } else {
                Box(
                    modifier = Modifier.size(80.dp),
                    contentAlignment = androidx.compose.ui.Alignment.Center
                ) {
                    Text("No Image")
                }
            }

            Column {
                content()
            }
        }
    }
}