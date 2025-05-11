package com.it.shka.searchairtickets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.GlideImage
import com.it.shka.data.model.Offer

@Preview(showBackground = true)
@Composable
fun AirScreen() {

    var textWhere = remember { mutableStateOf( "" ) }
    var text = remember { mutableStateOf( "" ) }
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .verticalScroll(state = scrollState)

        //horizontalAlignment = Alignment.CenterHorizontally
    ) { // Text on the screen
        Text(text = "Поиск дешевых авиабилетов",

            color = Color.White,
            fontSize = 22.sp,
            modifier = Modifier
                .padding(60.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
            )
        Box (modifier = Modifier
            .padding(16.dp)
            .wrapContentSize()
            .fillMaxWidth()
            .background(colorResource(R.color.back_search1), shape = RoundedCornerShape(16.dp)),
            Alignment.Center
        ){
            Row(modifier = Modifier
                .wrapContentSize()
                .fillMaxWidth()
                .padding(16.dp)
                .background(colorResource(R.color.back_search2), shape = RoundedCornerShape(16.dp)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(modifier = Modifier
                    .padding(start = 10.dp,5.dp)
                    .size(width = 24.dp, height = 24.dp),
                    tint = colorResource(R.color.black),
                    painter = painterResource(R.drawable.icon_search),
                    contentDescription = null,)
                Column (
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(5.dp)

                ){
                    TextField(
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent ,
                            unfocusedContainerColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedTextColor = colorResource(R.color.Basic_Grey_6),
                            focusedTextColor = Color.White
                        ),
                        placeholder = {
                            Text(
                                fontSize = 16.sp,
                                color = colorResource(R.color.Basic_Grey_6),
                                text= "Минск")
                        },
                        value = textWhere.value,
                        onValueChange = {textWhere.value = it}
                    )
                    Spacer(modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .padding(start = 16.dp, end = 16.dp)
                        .background(colorResource(R.color.Basic_Grey5)))

                    TextField(
                        value = text.value,
                        placeholder = {Text(
                            fontSize = 16.sp,
                            color = colorResource(R.color.Basic_Grey_6),
                            text= "Куда - Турция")},
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent ,
                            unfocusedContainerColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            disabledTextColor = colorResource(R.color.Basic_Grey_6),
                            unfocusedTextColor = colorResource(R.color.Basic_Grey_6),
                            focusedTextColor = Color.White
                        ),
                        onValueChange = {text.value = it}
                    )

                }
            }
        }
        Text(modifier = Modifier
            .padding(15.dp),
            text = "Музыкально отлететь",
            color = Color.White,
            fontSize = 22.sp
            )
        LazyRow (modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize()
                ){
            items(listOf(
                Offer(R.drawable.image1, "от 5000 ₽", "Die Antwoord", "Будапешт"),
                Offer(R.drawable.image2, "от 1999 ₽", "Socrat&Lera", "Санкт-Петербур"),
                Offer(R.drawable.image3, "от 2390 ₽", "Лампабикт", "Москва")

            )){ data->
                ItemList(data)
            }
        }
        Button(modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize()
            .padding(16.dp)
            .background(color = colorResource(R.color.Basic_Grey_3), shape = RoundedCornerShape(8.dp)),
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.Basic_Grey_3),
                contentColor = colorResource(R.color.Basic_Grey_3)
            )

        ) {
            Text(modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(),
               text =  "Показать все места",
                color = Color.White,
                fontSize = 16.sp
            )
        }
    }

}
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