package com.tavieto.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class Story(
    val title: String,
    val location: String,
    val image: Int,
    val date: String
)

class MainActivity : ComponentActivity() {

    private val listStories = listOf(
        Story(
            "Praia bonita",
            "Davenport, California",
            R.drawable.header,
            "December 2018"
        ),
        Story(
            "Muito bonita",
            "Ilhéus, Bahia",
            R.drawable.header,
            "July 2017"
        ),
        Story(
            "Belíssima",
            "Tokyo, Japão",
            R.drawable.header,
            "January 2020"
        ),
        Story(
            "Show de bola",
            "Roma, Itália",
            R.drawable.header,
            "May 2006"
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(listStories) { story ->
                    NewsStory(story)
                }
            }
        }
    }
}

@Composable
fun NewsStory(story: Story) {
    MaterialTheme {
        Column(
            modifier = Modifier.padding(16.dp),
        ) {
            Image(
                painter = painterResource(id = story.image),
                contentDescription = null,
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                story.title,
                style = typography.h6,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                story.location,
                style = typography.body2
            )
            Text(
                story.date,
                style = typography.body2
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewGreeting() {
    NewsStory(
        Story(
            "Praia bonita",
            "Davenport, California",
            R.drawable.header,
            "December 2018"
        )
    )
}