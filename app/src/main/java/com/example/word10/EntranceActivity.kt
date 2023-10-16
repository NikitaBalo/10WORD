package com.example.word10

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.word10.ui.theme.Word10Theme

class EntranceActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Word10Theme {
                Navigation()
            }
        }
    }
}

@Composable
fun EntryView(navController: NavController, btn_text: String) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
        ){
            Box(modifier = Modifier
                .fillMaxWidth(0.7f)
                .fillMaxHeight(0.35f)) {
                OutlinedButton(onClick = {
                    navController.navigate(Screen.MainInterface.route)
                },
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Text(text = btn_text,
                        fontSize = 35.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                        .align(Alignment.CenterVertically),
                        style = LocalTextStyle.current.merge(
                            TextStyle(
                                lineHeight = 1.em,
                                platformStyle = PlatformTextStyle(
                                    includeFontPadding = false
                                ),
                                lineHeightStyle = LineHeightStyle(
                                    alignment = LineHeightStyle.Alignment.Center,
                                    trim = LineHeightStyle.Trim.None
                                )
                            )
                        ))
                }
            }
        }
    }
}

@Composable
fun EntryScreen2(navController: NavController, word: String?) {

    var changed by remember { mutableStateOf(false) }
    val context = LocalContext.current

    LaunchedEffect(key1 = Unit) {
        if (!changed) {
            if (word != null) {
                if (word.length < 10) {
                    Toast.makeText(context, "Игра не была завершена", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(context, "Ваше слово: $word. Поздравляю у тебя получилось собрать слово.", Toast.LENGTH_LONG).show()
                }
            }
            changed = true
        }
    }

    EntryView(navController = navController, btn_text = "Продолжить игру")
}

@Composable
fun EntryScreen1(navController: NavController) {
    EntryView(navController = navController, btn_text = "Начать игру")
}

//@Preview (showBackground = true)
//@Composable
//fun Lite() {
//    EntryScreen(navController = null)
//}