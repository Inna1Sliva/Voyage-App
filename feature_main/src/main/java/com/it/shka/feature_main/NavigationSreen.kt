package com.it.shka.feature_main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.it.shka.feature_main.domain.model.Offer


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ItemList(item:Offer){
    Column (
        modifier = Modifier
            .padding(16.dp)
    ){ //
        GlideImage(
            modifier = Modifier
                .size(width = 133.dp, height = 134.dp)
                .padding(5.dp)
                .clip(RoundedCornerShape(16.dp)),
            loading = placeholder(painterResource(R.drawable.fire_icon)),
            contentScale = ContentScale.FillBounds,
            model = item.image,
            contentDescription = "картинка"
        )

        Text(
            modifier = Modifier
                .padding(start = 5.dp, top = 5.dp),
            text = item.title ,
            color = Color.White,
            fontSize = 16.sp
        )
        Text(
            modifier = Modifier
                .padding(start = 5.dp),
            text = item.town ,
            color = Color.White,
            fontSize = 14.sp
        )
        Row (modifier = Modifier
            .padding(3.dp),
            horizontalArrangement = Arrangement.Center
        ){
            Image(modifier = Modifier
                .size(width = 18.dp, height = 18.dp)
                .align(Alignment.CenterVertically),
                painter = painterResource(R.drawable.air),
                contentDescription = ""
            )
            Text(modifier = Modifier
                .align(Alignment.CenterVertically),
                text = item.price.value.toString() ,
                color = Color.White,
                fontSize = 14.sp
            )
        }

    }
}






