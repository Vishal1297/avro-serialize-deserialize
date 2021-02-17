package org.test

import org.test.model.Employee
import java.util.*

fun main() {

    val employee = Employee("A", 1120, 1500, 22, "")

    val listOfObjects = mutableListOf(
        Employee("A", 1120, 150000, 26, "abc"),
        Employee("C", 2120, 15000, 20, "xyz"),
        Employee("D", 4120, 25000, 21, "rty")
    )

    val inputKey = Scanner(System.`in`)
    print("Enter \n1 -> serialize : \n2 -> deSerialize : \n\t")
    when (inputKey.nextInt()) {
        1 -> Serialize().serializeClass(employee, listOfObjects)
        2 -> Deserialize().deserializeClass(employee)
    }

}