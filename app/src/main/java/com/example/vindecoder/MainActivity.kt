package com.example.vindecoder

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Badge
import androidx.compose.material.BadgedBox
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.vindecoder.ui.theme.VINDECODERTheme


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            window.statusBarColor = getColor(R.color.black)
            VINDECODERTheme {
                val navController = rememberNavController()
                Scaffold (
                    topBar = {
                        Column(
                            modifier = Modifier
                                .background(Color.Black)
                                .fillMaxWidth(),
                            horizontalAlignment = CenterHorizontally,
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo),
                                contentDescription = "Image",
                                modifier = Modifier
                                    .padding(16.dp)
                                    .width(150.dp)

                            )
                        }
                    },
                    bottomBar = {
                        BottomNavigationBar(
                            items = listOf(
                                BottomNavItem(
                                    name = "Home",
                                    route = "home",
                                    icon = Icons.Default.Home
                                ),
                                BottomNavItem(
                                    name = "Decoder",
                                    route = "decoder",
                                    icon = Icons.Default.Lock
                                ),
                                BottomNavItem(
                                    name = "Highlighted",
                                    route = "highlighted",
                                    icon = Icons.Default.Star
                                ),
                            ),
                            navController = navController,
                            onItemClick = {
                                navController.navigate(it.route)
                            },
                            modifier = Modifier.height(70.dp)
                        )
                    }
                ){
                        Navigation(navController = navController)
                    }
                }
            }
        }
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen()
        }
        composable("decoder") {
            DecoderScreen()
        }
        composable("highlighted") {
            HighlightedScreen()
        }
    }
}

@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.Black,
        elevation = 5.dp

    ) {
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(item) },
                selectedContentColor = Color("#FE7833".toColorInt()),
                unselectedContentColor = Color.Gray,
                icon = {
                    Column(
                        horizontalAlignment = CenterHorizontally
                    ) {
                        if (item.badgeCount > 0) {
                            BadgedBox(
                                badge = {
                                    Badge {
                                        Text(item.badgeCount.toString())
                                    }
                                }
                            ) {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.name,
                                    modifier = Modifier.size(26.dp)
                                )
                            }
                        } else {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.name,
                                modifier = Modifier.size(26.dp)
                            )
                        }
                        if (selected) {
                            Text(
                                text = item.name,
                                textAlign = TextAlign.Center,
                                fontSize = 14.sp
                            )
                        }
                    }
                }
            )
        }
    }
}