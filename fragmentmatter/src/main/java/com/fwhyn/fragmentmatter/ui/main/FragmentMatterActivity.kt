package com.fwhyn.fragmentmatter.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.fwhyn.fragmentmatter.ui.fragmentation.FragmentationActivity
import com.fwhyn.fragmentmatter.ui.theme.AndroidShimasuTheme

class FragmentMatterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidShimasuTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GoToFragmentation(Modifier.wrapContentSize())
                }
            }
        }
    }
}

@Composable
fun GoToFragmentation(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Button(
        onClick = {
            context.startActivity(Intent(context, FragmentationActivity::class.java))
        },
        modifier = modifier
    ) {
        Text(text = "Open Fragment")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidShimasuTheme {
        Greeting("Android")
        GoToFragmentation()
    }
}