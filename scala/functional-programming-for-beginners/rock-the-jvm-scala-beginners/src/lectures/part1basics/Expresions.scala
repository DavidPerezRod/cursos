package lectures.part1basics

object Expresions extends App {
  val x = 1 + 2 //EXPRESSION
  println(x)

  println(2 + 3 * 4)
  // + - * / & | ^ << >> >>> (right shift with zero extension)

  println(1 == x)
  // == != > >= < <= (por algún motivo cambia las expresiones ! =   > =  < = si se escriben juntas, por eso se ve así)

  println(!(1 == x))
  // ! && ||

  var aVariable = 2
  aVariable += 3 // also works with -= *= /= ... side effects
  println(aVariable)

  //Instructions vs Expressions
  // Instructions --> say to computer DO
  // Expressions --> giva a value

  //IF expression
  val aCondition = true
  val aConditionedValue = if (aCondition) 5 else 3 //if expresion no if instruction
  println(aConditionedValue)
  println(if (aCondition) 5 else 3)


  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }
  //NEVER WRITE THIS AGAIN
  //EVERYTHING IN SCALA IS AN EXPRESIÓN
  val aWeirdValue = (aVariable = 3) // Unit == void
  println(aWeirdValue)

  //side effects: println(), whiles, reassigning

  //code blocks -->special type of expressions
  val aCodeBlock = {
    val y=2
    val z = y+1
    if (z>2)"hello" else "goodbye"
  }
  //val anotherValue = z+1 --> z is not visible here

  //1. difference between "hello world" vs println("hello world")
  // 2. behaviour: pay attention
  val someValue={
    2<3
  }
  println(someValue)
  val someOtherValue = {
    if (someValue) 239 else 986
    42
  }
  println(someOtherValue)
}