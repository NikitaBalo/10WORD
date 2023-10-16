package com.example.word10

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.word10.ui.theme.Word10Theme

class Game : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Word10Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    MainInterface()
                }
            }
        }
    }
}

//@Composable
//fun rememberNavController(): NavHostController {
//
//}

@Composable
fun ButtonDev() {
    val context = LocalContext.current
    OutlinedButton(onClick = { Toast.makeText(context, "Программу разработал: Балобанов Никита Сергеевич", Toast.LENGTH_LONG).show(); },
        modifier = Modifier
            .fillMaxHeight(0.8f)
            .width(intrinsicSize = IntrinsicSize.Max)
    ) {
        Text(text = "Разработчики")
    }
}

@Composable
fun ButtonEnd(navController: NavController, letters: MutableList<Character>) {
    OutlinedButton(onClick = {
        var word = ""
        letters.forEach { letter ->
            if (letter.checked.value) {
                word += (letter.getLetter().toString())
            }
        }
        if (word.isEmpty()) {
            word = "1"
        }
        navController.navigate(Screen.EntryScreen2.withArgs(word))
    },
        modifier = Modifier
            .fillMaxHeight(0.8f)
            .width(intrinsicSize = IntrinsicSize.Max)
    ) {
        Text(text = "Завершить игру")
    }
}


@Composable
fun ButtonGenerate(letters: MutableList<Character>) {
    OutlinedButton(onClick = { letters.forEach{ if (!it.checked.value) it.setPosition(it.position.value)} },
        modifier = Modifier
            .fillMaxHeight(0.8f)
            .width(intrinsicSize = IntrinsicSize.Max)
    ) {
        Text(text = "Сгенерировать букву")
    }
}


@Composable
fun Letter(letter: Character) {
    val _letter = remember {letter}
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .height(50.dp)
            .width(50.dp)
            .background(
                if (_letter .checked.value) {
                    Color.Green
                } else {
                    MaterialTheme.colorScheme.secondary
                }
            )
            .clickable {
                _letter .checked.value = !_letter .checked.value
            })
    {
        Text(text = letter.getLetter().toString(),
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.background,
            fontSize = 50.sp,
            style = LocalTextStyle.current.merge(
                TextStyle(
                    lineHeight = 0.4.em,
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    ),
                    lineHeightStyle = LineHeightStyle(
                        alignment = LineHeightStyle.Alignment.Center,
                        trim = LineHeightStyle.Trim.FirstLineTop
                    )
                )
            )
        )
    }
}

@Composable
fun LettersColumn(letters: MutableList<Character>) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxSize()
    ) {
        for (i in 1..10) {
            Letter(letter = letters[i-1])
        }
    }
}


@Composable
fun MainInterface(navController: NavController) {
    val letters: MutableList<Character> = remember {
        mutableListOf(
            Character().init(),
            Character().init(),
            Character().init(),
            Character().init(),
            Character().init(),
            Character().init(),
            Character().init(),
            Character().init(),
            Character().init(),
            Character().init()
        )
    }
    Column (verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
        .fillMaxSize()) {
        Row (horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxHeight(fraction = 0.075f)
                .fillMaxWidth()
        ){
            ButtonDev()
        }
        Row (horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.8f)
                .background(MaterialTheme.colorScheme.onBackground)) {
            LettersColumn(letters)
        }
        Row (horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max)) {
            ButtonGenerate(letters)
            ButtonEnd(navController, letters)
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun Preview() {
//    Word10Theme {
//        Surface (modifier = Modifier
//            .width(500.dp)
//            .height(1000.dp)) {
//            MainInterface()
//        }
//    }
//}