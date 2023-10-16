package com.example.word10

sealed class Screen(val route: String) {
    object EntryScreen1 : Screen("entry1_screen")
    object EntryScreen2 : Screen("entry2_screen")
    object MainInterface : Screen("main_interface")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach {arg ->
                append("/$arg")
            }
        }
    }
}
