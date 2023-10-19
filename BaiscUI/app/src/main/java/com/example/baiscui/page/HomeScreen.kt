package com.example.baiscui.page

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.baiscui.BottomMenu
import com.example.baiscui.R
import com.example.baiscui.models.BottomMenuContent
import com.example.baiscui.models.Course
import com.example.baiscui.ui.theme.*

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .background(Black)
            .fillMaxSize()
    ) {
        Column {
            GreetingSection()
            ChipSection(
                chips = listOf(
                    "Data structures",
                    "Algorithms",
                    "competitive programming",
                    "python"
                )
            )
            SuggestionSection()
            CourseSection(
                courses = listOf(
                    Course(
                        title = "geek of the year",
                        R.drawable.ic_play,
                    ),
                    // below are the copies of the objects
                    // and you can add as many as you want
                    Course(
                        title = "How does AI Works",
                        R.drawable.ic_play,
                    ),
                    Course(
                        title = "Advance python Course",
                        R.drawable.ic_play,
                    ),
                    Course(
                        title = "Advance Java Course",
                        R.drawable.ic_play,
                    ),
                    Course(
                        title = "prepare for aptitude test",
                        R.drawable.ic_play,
                    ),
                    Course(
                        title = "How does AI Works",
                        R.drawable.ic_play,
                    ),
                )
            )
        }
        BottomMenu(
            items = listOf(
                BottomMenuContent(title = "Home", R.drawable.ic_play),
                BottomMenuContent(title = "Home", R.drawable.ic_play),
                BottomMenuContent(title = "Home", R.drawable.ic_play),
                BottomMenuContent(title = "Home", R.drawable.ic_play),
                BottomMenuContent(title = "Home", R.drawable.ic_play),
            ),
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}


@Composable
fun GreetingSection(name: String = "Asif") {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            // heading text view
            Text(
                text = "Good morning, $name",
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = "We wish you have a good day!",
                style = MaterialTheme.typography.bodyLarge
            )
        }
        // search icon
        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "Search",
            tint = White,
            modifier = Modifier.size(28.dp)
        )
    }
}

@Composable
fun ChipSection(chips: List<String>) {
    val selectedChipIndex = remember { mutableStateOf(0) }
    LazyRow {
        items(chips.size) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(
                        start = 15.dp,
                        bottom = 15.dp,
                        top = 15.dp,
                        end = if (chips.size == (it + 1)) 15.dp else 0.dp
                    )
                    .clickable { selectedChipIndex.value = it }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedChipIndex.value == it) Purple40
                        else PurpleGrey40
                    )
                    .padding(10.dp)
            ) {
                Text(text = chips[it], color = White, style = MaterialTheme.typography.titleSmall)
            }
        }
    }
}

@Composable
fun SuggestionSection() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(PurpleGrey40)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()
    ) {
        Column {
            Text(
                text = "Daily Coding",
                color = White,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "do at least • 3-10 problems / day",
                color = White,
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Box(
            // box containing icon
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Purple40)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_play_circle),
                contentDescription = "Play",
                tint = White,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Composable
fun CourseSection(courses: List<Course>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "courses",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(15.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(courses) {
                CourseItem(course = it)
            }
        }
    }
}

@Composable
fun CourseItem(course: Course) {
    Box(
        modifier = Modifier
            .height(200.dp)
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(PurpleGrey40)
            .padding(15.dp)
    ) {
        Text(text = course.title)
        Icon(
            painter = painterResource(id = R.drawable.ic_play),
            contentDescription = "Play",
            tint = White,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .size(30.dp)
        )
        Text(
            text = "Start", color = White,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .clip(RoundedCornerShape(10.dp))
                .background(Purple40)
                .padding(vertical = 6.dp, horizontal = 15.dp)
        )
    }
}


@Composable
fun BottomBar(data: List<BottomMenuContent>) {
    Box() {
        Text(
            text = data[0].title,
            style = MaterialTheme.typography.titleSmall,
            color = White,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

