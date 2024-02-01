// 1. Сумма ряда
fun alternatingSum() {
    val n = readLine()!!.toInt()
    var sum = 0
    var sign = 1
    for (i in 1..n) {
        val number = readLine()!!.toInt()
        sum += sign * number
        sign *= -1
    }
    println(sum)
}

// 2. Логистический максимин
fun logisticMaximin() {
    val roads = readLine()!!.toInt()
    var maxTunnelHeight = 0
    var maxRoad = 0
    for (i in 1..roads) {
        val tunnels = readLine()!!.toInt()
        var minTunnelHeight = Int.MAX_VALUE
        for (j in 1..tunnels) {
            val tunnelHeight = readLine()!!.toInt()
            if (tunnelHeight < minTunnelHeight) {
                minTunnelHeight = tunnelHeight
            }
        }
        if (minTunnelHeight > maxTunnelHeight) {
            maxTunnelHeight = minTunnelHeight
            maxRoad = i
        }
    }
    println("$maxRoad $maxTunnelHeight")
}

// 3. Дважды четное число
fun twiceEven() {
    val number = readLine()!!.toInt()
    val digits = number.toString().map { it.toString().toInt() }
    val sum = digits.sum()
    val product = digits.reduce { acc, i -> acc * i }
    if (sum % 2 == 0 && product % 2 == 0) {
        println("Число $number является 'дважды четным'")
    } else {
        println("Число $number не является 'дважды четным'")
    }
}

// 4. Найти наибольшую подстроку без повторяющихся символов
fun longestSubstringWithoutRepeatingCharacters() {
    val string = readLine()!!
    var longestSubstring = ""
    var currentSubstring = ""
    for (char in string) {
        if (char in currentSubstring) {
            currentSubstring = currentSubstring.substringAfter(char)
        }
        currentSubstring += char
        if (currentSubstring.length > longestSubstring.length) {
            longestSubstring = currentSubstring
        }
    }
    println(longestSubstring)
}

// 5. Найти максимальный элемент в каждой строке двумерного массива
fun maxElementInEachRow() {
    val rows = readLine()!!.toInt()
    val cols = readLine()!!.toInt()
    val matrix = Array(rows) { IntArray(cols) }
    val maxElements = IntArray(rows)
    for (i in 0 until rows) {
        for (j in 0 until cols) {
            matrix[i][j] = (1..100).random()
        }
        maxElements[i] = matrix[i].maxOrNull()!!
    }
    println(maxElements.joinToString(", "))
}
