package kr.example.jetnote.screens.screenc

fun calculateTotalTip(totalBill: Double, tipPercentage: Int): Double {
    if (totalBill > 1  && totalBill.toString().isNotEmpty()) {
        return (totalBill * tipPercentage ) / 100
    }
    return 0.0
}

fun calculateTotalPerPerson(totalBill: Double, splitValue: Int, tipPercentage: Int): Double {
    val bill = calculateTotalTip(totalBill, tipPercentage) + totalBill
    return (bill/ splitValue)
}