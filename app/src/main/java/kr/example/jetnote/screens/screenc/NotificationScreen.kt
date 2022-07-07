package kr.example.jetnote.screens.screenc

import android.icu.text.DecimalFormat
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.example.jetnote.screens.screenc.component.InputField
import kr.example.jetnote.screens.screenc.component.RoundedIconButton

@Composable
fun NotificationScreen() {
    Surface {
        MainContent()
    }
}


@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun MainContent() {

    val totalPersonState = remember { mutableStateOf(0.0)}
    val tipAmountState = remember {
        mutableStateOf(0.0)
    }
    val splitValueState = remember { mutableStateOf(1)}
    BillForm(
        totalPersonState = totalPersonState,
        tipAmountState = tipAmountState,
        splitValueState = splitValueState
    )

}

@OptIn(ExperimentalComposeUiApi::class)
@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun BillForm(
    onValueChange: (String)-> Unit = {},
    totalPersonState: MutableState<Double>,
    tipAmountState: MutableState<Double>,
    splitValueState: MutableState<Int>
) {

    var totalBillState = remember { mutableStateOf("") }
    val validState = remember(totalBillState.value) {
        totalBillState.value.isNotEmpty()
    }

    // var totalPersonState = remember { mutableStateOf(1)}
    var sliderPositionState = remember { mutableStateOf(0f)}

    val tipPercentage = (sliderPositionState.value * 100).toInt()
    val keyboardController = LocalSoftwareKeyboardController.current

    Column() {
        TopHeader(totalPrice = totalPersonState.value)
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp),
            shape= RoundedCornerShape(corner= CornerSize(3.dp)),
            border = BorderStroke(width = 3.dp, color = Color(0xFFe9ecef))
        ) {
            Column(
                modifier = Modifier
                    .padding(6.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Top
            ) {
                InputField(
                    valueState = totalBillState,
                    labelId ="금액",
                    enabled = true,
                    isSingleLine = true,
                    onAction = KeyboardActions {
                        if (!validState) {
                            return@KeyboardActions
                        }
                        onValueChange(totalBillState.value.trim())
                        totalPersonState.value = calculateTotalPerPerson(
                            totalBill = totalBillState.value.toDouble(),
                            splitValue = splitValueState.value,
                            tipPercentage = tipPercentage
                        )
                        keyboardController?.hide()

                    }
                )
                if (validState) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(6.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text="인원:", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RoundedIconButton(
                                imageVector = Icons.Default.Remove,
                                onClick = {
                                    if (splitValueState.value > 1) {
                                        splitValueState.value = splitValueState.value - 1
                                    } else {
                                        splitValueState.value = 1
                                    }
                                    if (validState) {
                                        totalPersonState.value = calculateTotalPerPerson(
                                            totalBill = totalBillState.value.toDouble(),
                                            splitValue = splitValueState.value,
                                            tipPercentage = tipPercentage
                                        )

                                    }

                                })
                            Spacer(modifier = Modifier.width(20.dp))
                            Text(text= "${splitValueState.value}", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
                            Spacer(modifier = Modifier.width(20.dp))
                            RoundedIconButton(
                                imageVector = Icons.Default.Add,
                                onClick = {
                                    if (splitValueState.value > 0) {
                                        splitValueState.value = splitValueState.value + 1
                                    } else {
                                        splitValueState.value = 1
                                    }
                                    if (validState) {
                                        totalPersonState.value = calculateTotalPerPerson(
                                            totalBill = totalBillState.value.toDouble(),
                                            splitValue = splitValueState.value,
                                            tipPercentage = tipPercentage
                                        )
                                    }
                                })

                        }
                    } // End of Row

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(6.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text="총팁 금액:", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
                        Text(text="${tipAmountState.value.toString()}  원", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
                    } // End of Row

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(6.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(text="${tipPercentage.toString()} %", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
                    }

                    Slider(
                        value = sliderPositionState.value,
                        onValueChange = { newValue ->
                            sliderPositionState.value = newValue
                            if (validState) {
                                totalPersonState.value = calculateTotalPerPerson(
                                    totalBill = totalBillState.value.toDouble(),
                                    splitValue = splitValueState.value,
                                    tipPercentage = tipPercentage
                                )
                                tipAmountState.value = calculateTotalTip(
                                    totalBill = totalBillState.value.toDouble(),
                                    tipPercentage = tipPercentage)
                            }
                        },
                        modifier = Modifier.padding(start=16.dp, end=16.dp),
                        enabled = true,
                        steps = 5)

                }

            }// End of Column
        }

    }
}

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun TopHeader(totalPrice: Double = 1000.0) {
    val dec = DecimalFormat("#,###")
    // val priceFormat = "%,d.0f".format(totalPrice)
    val priceFormat = dec.format(totalPrice)
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 10.dp)
            .height(150.dp)
            .clip(shape = CircleShape.copy(all = CornerSize(12.dp))),
        color =Color(0xFFeebefe)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(text="개인당 금액", style= TextStyle(color= Color.Black), fontWeight = FontWeight.Bold,
                fontSize = 20.sp)
            Spacer(modifier= Modifier.height(5.dp))
            Text(text="$priceFormat 원", style = TextStyle(color=Color.Black, fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            ))
        }
    }

}