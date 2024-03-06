package com.example.lab2

import android.content.Context
import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab2.ui.theme.Lab2Theme

class MainActivity : ComponentActivity() {

    //For Lab2Task3
    private val dataList = listOf<CharacterCardModel>(
        CharacterCardModel("Iron Man", 43, R.drawable.ic_iron_man),
        CharacterCardModel("Hulk", 56, R.drawable.hulk),
        CharacterCardModel("Thor", 1500, R.drawable.thor),
        CharacterCardModel("Captain Marvel", 100, R.drawable.marvel),
        CharacterCardModel("Tchaka Sis", 19, R.drawable.sis),
        CharacterCardModel("Valkrye", 34, R.drawable.valkrye),
        CharacterCardModel("War Machine", 49, R.drawable.warmachine),
        CharacterCardModel("Ant Man", 23, R.drawable.antman)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Lab2Task1()
                    //Lab2Task2()
                    //Following is the Lab2Task3()
                    CharacterList(dataList = dataList, LocalContext.current)
                    //Lab2Task4()
                }
            }
        }
    }
}

//For Lab2Task4
@Composable
fun Lab2Task4() {
    val list = (1..10).map { it.toString() }

    LazyVerticalGrid(
        columns = GridCells.Adaptive(156.dp),
        // content padding
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 16.dp,
            bottom = 12.dp
        ),
        content = {
            items(list.size) { index ->
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    ),
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 6.dp
                    ),
                ) {
                    Image(painter = painterResource(id = R.drawable.sis), contentDescription = null)
                    Text(
                        text = list[index],
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    )
}

//For Lab2Task3
@Composable
fun CharacterList(
    dataList: List<CharacterCardModel>,
    context: Context
) {
    LazyColumn {
        items(dataList) { data ->
            CharacterCard(data = data, context)
        }
    }
}

//For Lab2Task3
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterCard(
    data: CharacterCardModel,
    context: Context
) {
    Card(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 8.dp, top = 8.dp),
        onClick = {
            Toast.makeText(
                context,
                "You clicked ${data.characterName}",
                Toast.LENGTH_LONG
            )
        },
    ) {
        Row(
            modifier = Modifier
                .padding(top = 16.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                painter = painterResource(id = data.imgId),
                contentDescription = null,
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .width(100.dp)
                    .height(100.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Text(
                    text = data
                        .characterName,
                    fontSize = 28.sp,
//                  fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(bottom = 4.dp)
                        .fillMaxWidth()
                )
                Text(
                    text = "Age: ${data.age}",
                    fontSize = 20.sp,
//                  fontWeight = FontWeight.Bold,
//                    fontStyle = FontStyle.Italic,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

//Lab2Task2
@Composable
fun Lab2Task2() {
    Row(
        modifier = Modifier
            .padding(top = 16.dp, bottom = 16.dp, start = 8.dp, end = 8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .width(100.dp)
                .height(100.dp)
        )
        Column(
            modifier = Modifier.padding(start = 8.dp)
        ) {
            Text(
                text = "Shafique Ahmed",
                fontSize = 28.sp,
//                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .fillMaxWidth()
            )
            Text(
                text = "023-20-0103",
                fontSize = 20.sp,
//                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

//Lab2Task1
@Composable
fun Lab2Task1() {
    var isPressed by rememberSaveable { mutableStateOf(false) }

    val buttonColor = if (isPressed) Color.Red else Color.Blue

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { isPressed = !isPressed },
            modifier = Modifier
                .padding(16.dp)
                .background(buttonColor)
                .width(150.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
        ) {
            Text(
                text = "Change Color",
                color = Color.White,
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.CenterVertically)
            )
        }
    }
}