fun hexDigit(n: Int): Char {
    when {
        n in 0..9 -> return '0' + n
        n in 10..15 -> return 'A' + n - 10
        else -> return '?'
    }
}

/**
 * n에 대한 조건만 있을 때 when (n) 으로 쓰고 n 생략 가능
 */
fun numberDescription(n: Int, max: Int = 100): String = when (n) {
    0 -> "Zero"
    1, 2, 3 -> "Small"
    in 4..9 -> "Medium"
    in 10..max -> "Large"
    !in Int.MIN_VALUE until 0 -> "Negative"
    else -> "Huge"
}

fun main() {
    println("def" in "abc".."xyz")
    val range = "abc".."xyz"
    println("xyz" in range) // 범위에 닫혀있음

    val twoDigits = 10 until 100
    println(5 in twoDigits) // false
    println(15 in twoDigits) // true
    println(100 in twoDigits) // false

    // step
    println(5 in 10 downTo 1) // true
    println(5 in 1 downTo 10) // false, 빈 진행임
    println(7 in 1..10 step 3) // true, 1,4,7,10

    // when 조건문
    println(hexDigit(8))
    println(hexDigit(12))
    println(hexDigit(16))
}