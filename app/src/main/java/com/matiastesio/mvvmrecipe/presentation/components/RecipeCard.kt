package com.matiastesio.mvvmrecipe.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import com.matiastesio.mvvmrecipe.R
import com.matiastesio.mvvmrecipe.domain.model.Recipe
import com.matiastesio.mvvmrecipe.utils.loadPicture

@Composable
fun RecipeCard(
    recipe: Recipe,
    onClick: () -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                bottom = 6.dp,
                top = 6.dp,
                start = 10.dp,
                end = 10.dp
            )
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = 8.dp
    ) {
        Column {
            recipe.featuredImage?.let {
                val image = loadPicture(url = it, defaultImage = R.drawable.empty_plate).value
                image?.let { img ->
                    Image(
                        bitmap = img.asImageBitmap(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .preferredHeight(225.dp),
                        contentScale = ContentScale.Crop
                    )
                }
            }
            recipe.title?.let { 
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 12.dp,
                            bottom = 12.dp,
                            start = 8.dp,
                            end = 8.dp
                        )
                ) {
                    Text(
                        text = it,
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .wrapContentWidth(Alignment.Start)
                            .align(Alignment.CenterVertically),
                        style = MaterialTheme.typography.h5
                    )
                    Text(
                        text = recipe.rating.toString(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.End)
                            .align(Alignment.CenterVertically),
                        style = MaterialTheme.typography.h6
                    )
                }
            }
        }
    }
}