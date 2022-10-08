import java.util.*

class Expression {
    fun initializeArray() {
        val a = arrayOf("hello", "world")
        val a2 : Array<String> = arrayOf("hello", "kotlin")
        // 참조 동등성 비교
        println(a == a2)
        val b = a.copyOf();
        // 배열 동등성 비교
        println(a.contentEquals(b))


    }
}