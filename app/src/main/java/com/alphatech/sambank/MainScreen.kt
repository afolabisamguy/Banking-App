package com.alphatech.sambank

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    var selectedIndex by remember {
        mutableIntStateOf(0)
    }
    Scaffold(
        bottomBar = {
            NavigationBar(
                tonalElevation = 5.dp
            ) {
                items.forEachIndexed{ index, item ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = {
                            selectedIndex = index
                        },
                        icon = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.title,
                                tint = MaterialTheme.colorScheme.onBackground
                            )
                        },
                        label = {
                            Text(text = item.title,
                                color = MaterialTheme.colorScheme.onBackground)
                        }
                )
            }
        }
    }
    ){
        padding ->
        ContentScreen(modifier = Modifier.padding(padding), selectedIndex = selectedIndex)
    }
}



@Composable
fun ContentScreen(modifier: Modifier, selectedIndex: Int){
    when(selectedIndex){
        0 -> HomeScreen()
        1 -> WalletScreen()
        2 -> NotificationsScreen()
        3 -> AccountScreen()
    }
}
