package io.a2kaido.mikan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "list") {
        composable("list") { ClippingList(navController) }
        composable("detail") { ClippingDetail() }
    }
}

@Composable
fun ClippingList(navController: NavController) {
    ScrollableColumn(
        modifier = Modifier
            .fillMaxWidth()
            .testTag("list")
    ) {
        (0..20).map {
            ClippingItem(title = "title", description = "いろはにほへと\nちりぬるを", navController)
        }
    }
}

@Composable
fun ClippingItem(title: String, description: String, navController: NavController) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = 4.dp
    ) {
        Column(
            Modifier
                .clickable(onClick = {
                    navController.navigate("detail")
                })
        ) {
            Text(
                modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                text = title
            )
            Text(
                modifier = Modifier.padding(start = 8.dp, bottom = 8.dp),
                text = description
            )
        }
    }
}

@Preview
@Composable
fun PreviewListView() {
    val navController = rememberNavController()
    ClippingList(navController)
}

@Composable
fun ClippingDetail() {
    Row {
        Text(text = "はるはあけぼの")
    }
}

@Preview
@Composable
fun PreviewDetail() {
    ClippingDetail()
}
