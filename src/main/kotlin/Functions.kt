import kotlin.math.PI

fun circleArea(radius: Double): Double {
    return PI * radius * radius
}

fun increment(a: IntArray): Int {
    /**
     * kotlin에서 기본적으로 파라미터는 불변 값이다. (자바의 final)
     * 또한 call by value를 따르므로 a를 변화시킬 수는 없지만, a가 참조하는 값의 데이터는 변경시킬 수 있다.
     * 이 함수를 호출하고 a를 조회하면 첫 요소에 1이 더해진다.
     * 그리고 파라미터와 반환값에는 꼭 타입을 명시해야 한다. (void일 경우(kotlin에서는 Unit이라는 상수를 반환)와 함수형 식을 적을 때는 제외)
     */
    return ++a[0]
}

fun rectangleArea(width: Double, height: Double): Double {
    return width * height
}

// 디폴트 파라미터
fun restrictToRange(
    from: Int = Int.MIN_VALUE,
    to: Int = Int.MAX_VALUE,
    what: Int
): Int = Math.max(from, Math.min(to, what))

// 가변인자
fun printSorted(vararg items: Int) {
    items.sort()
    println(items.contentToString())
}

fun main() {
//    print("Enter radius: ")
//    val radius = readLine()!!.toDouble()
//    println("Circle area: ${circleArea(radius)}")

    val a = intArrayOf(1, 2, 3)
    println(increment(a))
    println(a.contentToString())

    rectangleArea(10.0, 5.0)
    // 이름 붙은 인자 호출
    rectangleArea(height = 5.0, width = 10.0)
    // 혼용
    rectangleArea(10.0, height = 5.0)

    /**
     * 디폴트 파라미터 뒤에 디폴트값이 없는 경우, 디폴트값을 설정하지 않고 호출하려면 이름 붙은 인자를 사용하는 방법밖에 없다.
     * 그래서 일반적으로 디폴트값이 존재하는 파라미터를 뒤쪽에 배치한다.
     */
    println(restrictToRange(10, what = 1))

    printSorted(1, 2, 3)
    printSorted(1, 10, 2, 3, 7)
    val numbers = intArrayOf(6, 2, 10, 1)
    /**
     * 스프레드 연산자 *로 가변인자에 배열을 넘길 수 있다. 단, 이 때 복사가 일어나므로 원본 배열에는 영향 X
     * 하지만 얕은 복사이므로 배열에 참조가 있는 경우에는 바뀔 수 있다.
     */
    printSorted(*numbers)

}