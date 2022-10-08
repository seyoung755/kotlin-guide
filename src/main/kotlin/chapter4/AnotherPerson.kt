package chapter4

import java.lang.IllegalArgumentException

class AnotherPerson(firstName: String, familyName: String) {
    val fullName = "$firstName $familyName"
}

class ParameterToPropertyPerson(val firstName: String, familyName: String) {
    val fullName = "$firstName $familyName"

    fun printFirstName() {
        println(firstName) // val로 파라미터에 선언하면 자동으로 프로퍼티화된다.
    }
}

// 프라퍼티만 가지면 본문을 생략할 수도 있음
class SimplePerson(val firstName: String, val familyName: String = "")

class ManyConstructorPerson {
    val firstName: String
    val familyName: String

    constructor(firstName: String, familyName: String) {
        this.firstName = firstName
        this.familyName = familyName
    }

    constructor(fullName: String) {
        val names = fullName.split(" ")
        if (names.size != 2) {
            throw IllegalArgumentException("Invalid name: $fullName")
        }
        firstName = names[0]
        familyName = names[1]
    }
}

class AnotherWayMayConstructorPerson {
    val fullName: String
    constructor(firstName: String, familyName: String):
        this("$firstName $familyName")
    constructor(fullName: String) {
        this.fullName = fullName
    }
}

class PrimaryConstructorPerson(val fullName: String) {
    constructor(firstName: String, familyName: String): // 여기 파라미터에는 val, var 사용 불가능
        this("$firstName $familyName")
}

class PrivateConstructor private constructor() {

}

class NestedPerson (val id: Id, val age: Int) {
    class Id(val firstName: String, val familyName: String)
    fun showMe() = println("${id.firstName} ${id.familyName}, $age")
}

class PrivateNestedPerson (private val id: Id, private val age: Int) {
    class Id(private val firstName: String, private val familyName: String)
//    fun showMe() = println("${id.firstName} ${id.familyName}, $age") Id의 멤버가 private이라서 사용불가능해짐
}

class InnerNestedPerson (val firstName: String, val familyName: String) {
    inner class Possession(val description: String) {
        fun showOwner() = println(fullName())
        fun getOwner() = this@InnerNestedPerson // 한정시킨 this
    }

    private fun fullName() = "$firstName $familyName" // inner 클래스에는 외부 클래스 접근가능
}

fun main() {
    val person = AnotherPerson("John", "Doe")
    println(person.fullName)
    val person2 = ParameterToPropertyPerson("John", "Doe")
    person2.printFirstName()
    val person3 = ManyConstructorPerson("John", "Doe")
    val person4 = ManyConstructorPerson("John Doe")
}