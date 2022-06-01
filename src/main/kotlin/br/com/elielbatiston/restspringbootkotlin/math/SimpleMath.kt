package br.com.elielbatiston.restspringbootkotlin.math

import java.lang.Math.sqrt

class SimpleMath {

    fun sum(numberOne: Double, numberTwo: Double) = numberOne + numberTwo

    fun subtraction(numberOne: Double, numberTwo: Double) = numberOne - numberTwo

    fun multiplication(numberOne: Double, numberTwo: Double) = numberOne * numberTwo

    fun division(numberOne: Double, numberTwo: Double) = numberOne / numberTwo

    fun mean(numberOne: Double, numberTwo: Double) = (numberOne + numberTwo) / 2

    fun squareRoot(number: Double) = sqrt(number)
}