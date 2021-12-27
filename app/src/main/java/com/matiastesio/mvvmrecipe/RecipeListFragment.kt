package com.matiastesio.mvvmrecipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.imageFromResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class RecipeListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                ScrollableColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color(0xFFF2F2F2))
                ) {
                    Image(
                        bitmap = imageFromResource(
                            res = resources,
                            resId = R.drawable.happy_meal_small
                        ),
                        modifier = Modifier.height(300.dp),
                        contentScale = ContentScale.Crop
                    )
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Happy meal",
                                style = TextStyle(
                                    fontSize = TextUnit.Companion.Sp(26)
                                )
                            )
                            Text(
                                text = "$50",
                                style = TextStyle(
                                    fontSize = TextUnit.Companion.Sp(17),
                                    color = Color(0xFF85bb65)
                                ),
                                modifier = Modifier.align(Alignment.CenterVertically)
                            )
                        }
                        Spacer(modifier = Modifier.padding(top = 10.dp))
                        Text(
                            text = "800 calories",
                            style = TextStyle(
                                fontSize = TextUnit.Companion.Sp(17)
                            )
                        )
                        Button(
                            onClick = {findNavController().navigate(R.id.action_recipeListFragment_to_recipeFragment2)},
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        ) {
                            Text(text = "ORDER NOW!")
                        }
                    }
                }
            }
        }
    }
}