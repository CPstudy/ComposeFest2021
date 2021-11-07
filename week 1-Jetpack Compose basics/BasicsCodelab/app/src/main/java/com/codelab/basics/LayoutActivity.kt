package com.codelab.basics

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.codelab.basics.ui.BasicsCodelabTheme

class LayoutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent {
            BasicsCodelabTheme {
                LayoutCodelab()
            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun LayoutCodelab() {
    Scaffold(
        topBar = {
            Text(
                text = "Layout Codelab",
                style = MaterialTheme.typography.h3)
        }
    ) { innerPadding ->
        BodyContent(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
private fun BodyContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Text(text = "Hi")
        Text(text = "This is Text")
    }
}