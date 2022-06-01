package kz.noxiq.chocoexpress.ui.utils

import java.text.NumberFormat

fun formatPrice(price: Int): String {
    val temp = NumberFormat.getInstance().format(price).toString()
    return temp.replace(",", " ") + " тг"
}

fun formatDate(date: String): String {

    val finalDate: String =
        "${date.substring(8,10)}." + //day
        "${date.substring(5,7)}." + //month
        "${date.substring(0,4)}, " + //year
                date.substring(11,16)
    return finalDate
}