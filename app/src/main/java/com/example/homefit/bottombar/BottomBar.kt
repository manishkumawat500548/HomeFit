package com.example.homefit.bottombar

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.homefit.R
import com.example.homefit.navigation.Routes

@Composable
fun BottomBar(navController: NavController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val itemList = listOf(
        ItemData(R.drawable.homebutton, "Home", Routes.Home),
        ItemData(R.drawable.line, "Workout", Routes.Workout),
        ItemData(R.drawable.history, "History", Routes.History),
        ItemData(R.drawable.exercise, "Exercises", Routes.Exercises),
        ItemData(R.drawable.user, "Profile", Routes.Profile)
    )

    NavigationBar(containerColor = Color(0xff01060e)) {
        itemList.forEachIndexed { index, data ->
            val isSelected = currentDestination?.hasRoute(data.routes::class)?:false

            NavigationBarItem(onClick = {navController.navigate(data.routes)},
                icon = { Icon(painter = painterResource(data.icon),contentDescription = null, modifier = Modifier.size(24.dp)) },
                label = {
                    Text(
                    data.text)
                },
                selected = isSelected,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFF6641df),
                    selectedTextColor = Color(0xFF6641df),
                    unselectedIconColor = Color.Gray,
                    unselectedTextColor = Color.Gray,
                    indicatorColor = Color.Transparent
                )

                )
        }
    }
}

data class ItemData(
    val icon: Int, val text: String, val routes: Routes
)