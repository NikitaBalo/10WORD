package com.example.word10

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.word10.ui.theme.Word10Theme

class Game : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Word10Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainInterface()
                }
            }
        }
    }
}

@Composable
fun ButtonDev() {
    val context = LocalContext.current
    OutlinedButton(onClick = { Toast.makeText(context, "Программу разработал: Балобанов Никита Сергеевич", Toast.LENGTH_LONG).show() },
        modifier = Modifier
            .fillMaxHeight(0.8f)
            .width(intrinsicSize = IntrinsicSize.Max)
    ) {
        Text(text = "Разработчики")
    }
}

@Composable
fun MainInterface() {
    Row (horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.Top,
        modifier = Modifier
            .fillMaxHeight(fraction = 0.075f)
            .fillMaxWidth()
    ){
        ButtonDev()
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
//    Word10Theme {
//        Surface (modifier = Modifier
//            .width(500.dp)
//            .height(1000.dp)) {
//            MainInterface()
//        }
//    }
}