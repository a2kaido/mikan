package io.a2kaido.mikan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.AmbientContext
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                ClippingList()
            }
        }
    }
}

@Composable
fun ClippingList() {
    ScrollableColumn(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        (0..20).map {
            ClippingItem(title = "title", description = "いろはにほへと\nちりぬるを")
        }
    }
}

@Composable
fun ClippingItem(title: String, description: String) {
    val context = AmbientContext.current
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = 4.dp
    ) {
        Column(
            Modifier
                .clickable(onClick = {
                    Toast.makeText(context, title, Toast.LENGTH_SHORT).show()
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
    ClippingList()
}
