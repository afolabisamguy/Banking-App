package com.alphatech.sambank

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alphatech.sambank.data.Card
import com.alphatech.sambank.ui.theme.BlueEnd
import com.alphatech.sambank.ui.theme.BlueStart
import com.alphatech.sambank.ui.theme.GreenEnd
import com.alphatech.sambank.ui.theme.GreenStart
import com.alphatech.sambank.ui.theme.OrangeEnd
import com.alphatech.sambank.ui.theme.OrangeStart
import com.alphatech.sambank.ui.theme.PurpleEnd
import com.alphatech.sambank.ui.theme.PurpleStart

val carditems = listOf(

    Card(
        cardType = "VISA",
        cardNumber = "1234 5678 9012 3456",
        cardName = "Business",
        balance = 75.23,
        color = getGradient(PurpleStart, PurpleEnd)
    ),

    Card(
        cardType = "MASTERCARD",
        cardNumber = "5625 7463 9012 2456",
        cardName = "Savings",
        balance = 93.23,
        color = getGradient(BlueStart, BlueEnd)
    ),

    Card(
        cardType = "VISA",
        cardNumber = "2351 6457 2564 3456",
        cardName = "School",
        balance = 12.23,
        color = getGradient(OrangeStart, OrangeEnd)
    ),

    Card(
        cardType = "MASTERCARD",
        cardNumber = "1234 5678 9012 3456",
        cardName = "Trips",
        balance = 59.23,
        color = getGradient(GreenStart, GreenEnd)
    ),


)

fun getGradient(
    startcolor: Color,
    endcolor: Color,
): Brush {
    return Brush.horizontalGradient(
        colors = listOf(startcolor, endcolor)
    )
}



@Preview
@Composable
fun CardSection(){
    LazyRow {
        items(carditems.size){index ->
            CardItem(index)
        }
    }
}

@Composable
fun CardItem(index: Int) {
    val card = carditems[index]
    var lastItemPaddingEnd = 0.dp
    if(index == carditems.size - 1){
        lastItemPaddingEnd = 16.dp
    }
    var image = painterResource(id = R.drawable.ic_visa)
    if (card.cardType == "MASTER CARD"){
        image = painterResource(id = R.drawable.ic_mastercard)
    }

    Box(
        modifier = Modifier
            .padding(start=16.dp, end =lastItemPaddingEnd))
    {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable {  }
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Image(
                painter = image,
                contentDescription = card.cardName,
                modifier = Modifier.width(60.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(text = card.cardName,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold)

            Text(text = "$ ${card.balance}",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold)

            Text(text = card.cardNumber,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold)

        }
    }
}
