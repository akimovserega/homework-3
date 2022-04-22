package ru.netology


fun main() {

// 6 вариантов:

    var numSeconds: Int = 30
    println(agoToText(numSeconds))

    numSeconds = 1850
    println(agoToText(numSeconds))

    numSeconds = 8936
    println(agoToText(numSeconds))

    numSeconds = 150_123
    println(agoToText(numSeconds))

    numSeconds = 187_781
    println(agoToText(numSeconds))

    numSeconds = 1_161_165
    println(agoToText(numSeconds))

}


fun agoToText(numSeconds: Int): String {

    var retString: String = "был(а) в сети "
    val recently: String = "был(а) только что"

    // условия по ДЗ
    when (numSeconds) {
        in 0..60 -> retString = recently
        in 61..60 * 60 -> retString += "${numSeconds / 60} ${minuteFormat(numSeconds / 60)} назад"
        in 60 * 60 + 1..24 * 60 * 60 -> retString += "${numSeconds / 3600} ${hourFormat(numSeconds / 3600)} назад"
        in 24 * 60 * 60 + 1..2 * 24 * 60 * 60 -> retString += "сегодня"
        in 2 * 24 * 60 * 60 + 1..3 * 24 * 60 * 60 -> retString += "вчера"
        else -> retString += "давно"
    }

    return retString
}


fun minuteFormat(num: Int): String {
    // -ы, -у. From 1 to 60
    return when (num % 10) {
        1 -> "минуту"
        in 2..4 -> "минуты"
        in 5..9, 0 -> "минут"
        else -> "мин."
    }
}

fun hourFormat(num: Int): String {
    //-а, -ов From 1 to 24
    return when (num % 10) {
        1 -> "час"
        in 2..4 -> "часа"
        in 5..9, 0 -> "часов"
        else -> "час."
    }
}