package com.example.word10

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import kotlin.random.Random

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.EntryScreen1.route) {
        composable(route = Screen.EntryScreen1.route) {
            EntryScreen1(navController = navController)
        }
        composable(route = Screen.MainInterface.route) {
            MainInterface(navController = navController)
        }
        composable(
            route = Screen.EntryScreen2.route + "/{word}",
            arguments = listOf(
                navArgument("word") {
                    type = NavType.StringType
                    defaultValue = "Игра не завершена!"
                    nullable = false
                })) {
            entry ->
            EntryScreen2(navController, entry.arguments?.getString("word"))
        }
    }
}

class Character {
    var checked: MutableState<Boolean> = mutableStateOf(false)
    var position: MutableState<Int> = mutableIntStateOf(0)
    private val letters: List<Char> = listOf('А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я')

    fun init(): Character {
        setPosition(position.value)
        return this
    }

    fun getLetter(): Char {
        return letters[position.value]
    }

    fun setPosition(currentPosition: Int){
        var index = Random.nextInt(0, letters.size - 1)
        while (index == currentPosition) {
            index = Random.nextInt(0, letters.size - 1)
        }
        position.value = index
    }
}