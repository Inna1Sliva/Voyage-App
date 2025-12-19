package com.it.shka.feature_main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.it.shka.feature_main.model.Offer
import com.it.shka.feature_main.presentation.DataViewModel


@Composable
fun ItemList(item:Offer){
    Column (
        modifier = Modifier
            .padding(16.dp)
    ){ //
            Image(
                modifier = Modifier
                    .size(width = 133.dp, height = 134.dp)
                    .padding(5.dp)
                    .background(color = Color.Transparent, shape = RoundedCornerShape(16.dp)),
                painter = painterResource(item.id),
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
                text = item.price ,
                color = Color.White,
                fontSize = 14.sp
            )
        }

    }
}
@Composable
fun HotelScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Text on the screen
        Text(text = "Hotel", color = Color.Black)
    }
}

@Composable
fun LocalScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Text on the screen
        Text(text = "Local", color = Color.Black)
    }
}

@Composable
fun NatificationScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Text on the screen
        Text(text = "Natification", color = Color.Black)
    }
}

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Text on the screen
        Text(text = "Profile", color = Color.Black)
    }
}