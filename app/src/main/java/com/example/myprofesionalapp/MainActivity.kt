package com.example.myprofesionalapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myprofesionalapp.ui.theme.MyProfesionalAppTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {

//            MyApp1()
            MyApp()
//            MyProfesionalAppTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.padding(12.dp),
//                ) {
////                    ContainerCard()
//                    ContainerCardLazyColumn()
//                }
//            }
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") { SplashScreen(navController) }
        composable("main") {
            MyApp1()
//            Surface(
//                    modifier = Modifier.padding(12.dp),
//                ) {
//                    ContainerCard()
//                }
        }
    }
}

@Composable
fun SplashScreen(navController: NavHostController) {
    LaunchedEffect(Unit) {
        delay(3000L)
        navController.navigate("main") {
            popUpTo("splash") { inclusive = true }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.white_primary)),
        contentAlignment = Alignment.Center
    ) {
        // Replace with your logo or image
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "App Logo",
            modifier = Modifier.size(150.dp)
        )
    }
}

@Preview(showBackground = true, name="ImageContent")
@Composable
fun ImageContent(modifier: Modifier = Modifier){
    Box(
        modifier = Modifier
            .size(128.dp)
            .clip(RoundedCornerShape(100.dp))
            .background(Color.LightGray)
            .padding(2.dp)
            .then(modifier)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profil_cihuy),
            contentDescription = "My Image",
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(100.dp)),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(showBackground = true, name="ProfileContent")
@Composable
fun ProfileContent(modifier: Modifier = Modifier){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Fajar Alam",
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "@go_jaru",
                fontWeight = FontWeight.Bold,
                fontSize = 10.sp
            )
        }
        Text(
            text = "Hello, my name Fajar Alam, but people call me jar. I'm a junior android developer. Nice to meet you!",
            textAlign = TextAlign.Center
        )
        Row (
            horizontalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            Column (

                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "20M",
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Likes",
                    fontWeight = FontWeight.Bold
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "10",
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Projects",
                    fontWeight = FontWeight.Bold
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "3",
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "YoE",
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Row (
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ){
            ButtonPrimary("Follow")
            InvertedButtonPrimary("View Profile")
        }
    }
}

@Preview(showBackground = true, name = "Button Primary")
@Composable
fun ButtonPrimary(text: String = "Button"){
    Button(
        onClick = { /*TODO*/ },
        shape = RoundedCornerShape(6.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.black_primary),
            contentColor = Color.White
        ),
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true, name = "Inverted Button Primary")
@Composable
fun InvertedButtonPrimary(text: String = "Button"){
    OutlinedButton(
        onClick = {  },
        shape = RoundedCornerShape(6.dp),
        border = BorderStroke(2.dp, colorResource(R.color.black_primary)),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = colorResource(id = R.color.black_primary)
        )
    ) {
        Text(text)
    }
}

@Preview(showBackground = true, name = "Container Card")
@Composable
fun ContainerCard() {
    Box (
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .paint(
                painterResource(id = R.drawable.background_container_card),
                contentScale = ContentScale.FillBounds
            )
    ) {
        Column (
            modifier = Modifier
                .padding(24.dp, 20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ImageContent(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            ProfileContent()
        }
    }
}

@Preview(showBackground = true, name = "Container Card Lazy Columns")
@Composable
fun ContainerCardLazyColumn() {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp, 12.dp, 0.dp, 12.dp)
    ){
        items(10){item ->
            ContainerCard()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp1() {

    val navigationState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    val navController = rememberNavController()
    val items = listOf(
        DrawerItem(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
        ),
        DrawerItem(
            title = "Daily Activity",
            selectedIcon = Icons.Filled.Info,
            unselectedIcon = Icons.Outlined.Info,
        ),
        DrawerItem(
            title = "Gallery",
            selectedIcon = Icons.Filled.Favorite,
            unselectedIcon = Icons.Outlined.FavoriteBorder,
        ),
        DrawerItem(
            title = "Music Favorite & Video",
            selectedIcon = Icons.Filled.Favorite,
            unselectedIcon = Icons.Outlined.FavoriteBorder,
        ),
    )

    // to define navigation drawer here

    Surface {
        ModalNavigationDrawer(
            drawerContent = {
                ModalDrawerSheet {
                    Spacer(modifier = Modifier.height(26.dp))
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        ImageContent()
                    }
                    Spacer(modifier = Modifier.height(26.dp))
                    items.forEachIndexed { index, drawerItem ->
                        NavigationDrawerItem(label = {
                            Text(text = drawerItem.title)
                        }, selected = index == selectedItemIndex, onClick = {
                            selectedItemIndex = index
                            scope.launch {
                                navigationState.close()
                            }
                            navController.navigate(drawerItem.title) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                restoreState = true
                                launchSingleTop = true
                            }
                        }, icon = {
                            Icon(
                                imageVector = if (index == selectedItemIndex) {
                                    drawerItem.selectedIcon
                                } else drawerItem.unselectedIcon,
                                contentDescription = drawerItem.title
                            )
                        }, badge = {
                            drawerItem.badgeCount?.let {
                                Text(text = drawerItem.badgeCount.toString())
                            }
                        }, modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                        )
                    }
                }
            },
            drawerState = navigationState,
        ) {
            Scaffold(topBar = {
                TopAppBar(title = {
                    Text(text = "My Professional App")
                }, navigationIcon = {
                    IconButton(onClick = {
                        scope.launch {
                            navigationState.open()
                        }
                    }) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                    }
                })
            }) {
                NavHost(
                    navController = navController,
                    startDestination = items[0].title,
                    modifier = Modifier.padding(it)
                ) {
                    composable("Home") { HomeScreen() }
                    composable("Daily Activity") { DailyActivityScreen() }
                    composable("Gallery") { GalleryScreen() }
                    composable("Music Favorite & Video") { MusicFavoriteVideoScreen() }
                }
            }
        }
    }
}

//@Composable
//fun DrawerFooter(
//) {
//    val uriHandler = LocalUriHandler.current
//
//    Column(
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Bottom,
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(bottom = 10.dp)
//    ) {
//
//
//        Spacer(modifier = Modifier.height(48.dp))
//        Text(
//            text = "Contact Creator",
//            fontStyle = FontStyle.Italic,
//            fontWeight = FontWeight.SemiBold,
//        )
//
//        LazyRow() {
//            item {
//                IconButton(onClick = { }) {
//                    Icon(
//                        painter = painterResource(id = R.drawable.ic_linkedin),
//                        modifier = Modifier.size(18.dp),
//                        contentDescription = "Linkedin"
//                    )
//                }
//                Spacer(modifier = Modifier.size(12.dp))
//
//                IconButton(onClick = { }) {
//                    Icon(
//                        painter = painterResource(id = R.drawable.ic_github),
//                        modifier = Modifier.size(18.dp),
//                        contentDescription = "Github"
//                    )
//                }
//
//                Spacer(modifier = Modifier.size(12.dp))
//
//                IconButton(onClick = { }) {
//                    Icon(
//                        painter = painterResource(id = R.drawable.ic_twitter),
//                        modifier = Modifier.size(18.dp),
//                        contentDescription = "Twitter"
//                    )
//                }
//            }
//        }
//    }
//}

data class DrawerItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val badgeCount: Int? = null
)

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Home Screen", fontSize = 24.sp)
    }
}

@Composable
fun DailyActivityScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Daily Activity Screen", fontSize = 24.sp)
    }
}

@Composable
fun GalleryScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Gallery Screen", fontSize = 24.sp)
    }
}

@Composable
fun MusicFavoriteVideoScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Music Favorite & Video Screen", fontSize = 24.sp)
    }
}