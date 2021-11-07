/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.codelab.basics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codelab.basics.ui.BasicsCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsCodelabTheme {
                MyApp()
            }
        }
    }
}

@Composable
private fun MyApp() {
    var shouldShowOnBoarding by remember { mutableStateOf(true) }

    if (shouldShowOnBoarding) {
        OnboardingScreen {
            shouldShowOnBoarding = false
        }
    } else {
        Surface {
            Text("apple")
        }
    }
}

@Composable
private fun OnboardingScreen(onContinueClicked: () -> Unit) {
    var enabled by remember {
        mutableStateOf(false)
    }

    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                color = MaterialTheme.colors.error,
                modifier = Modifier.padding(12.dp)
            ) {
                if (enabled) {
                    Text(
                        text = "Welcome to the Basics Codelab!",
                        modifier = Modifier.padding(20.dp)
                    )
                } else {
                    Text(
                        text = "Welcome to the Basics Codelab! $enabled",
                        modifier = Modifier.padding(20.dp)
                    )
                }
            }
            Button(
                modifier = Modifier.padding(vertical = 24.dp),
                onClick = onContinueClicked
            ) {
                Text("Continue")
            }
            Row() {
                Button(
                    onClick = {
                        enabled = !enabled
                    }
                ) {
                    Text("Row1")
                }
                Button(
                    onClick = {
                        enabled = !enabled
                    }
                ) {
                    Text("Row2")
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    BasicsCodelabTheme {
        OnboardingScreen(onContinueClicked = {})
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun LayoutCodelab() {
    BasicsCodelabTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Layout Codelab"
                        )
                    },
                    actions = {
                        IconButton(onClick = {

                        }) {
                            Icon(Filled.Favorite, contentDescription = null)
                        }
                    }
                )
            },
        ) { innerPadding ->
            BodyContent(modifier = Modifier
                .padding(innerPadding)
                .padding(8.dp)
            )
        }
    }
}

@Composable
private fun BodyContent(modifier: Modifier = Modifier) {
    Surface {
        Text("apple")
    }
}