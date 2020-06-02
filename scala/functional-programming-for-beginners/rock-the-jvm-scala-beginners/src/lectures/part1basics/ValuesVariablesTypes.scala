package lectures.part1basics

object ValuesVariablesTypes extends App {
  ///////////////////////
  //FIRST SECTION VALS
  ///////////////////////

  //FIRST TIP: vals are inmutable
  val anInt: Int  = 42

  //SECOND TIP: the type could be inferred by compiler
  val anotherInt = 43

  val string= "hello"

  val aBoolean = false
  val aChar = 'a'
  val aShort = 234523523

  //THIRD TIP:
  //          longs end with 'L'
  //          floats end with 'f'
  val aLong = 1234323123413434234L
  val aFloat= 2.0f
  val double= 2.0

  ///////////////////////
  //SECOND SECTION VARS
  ///////////////////////
  var aVariable: Int= 4
  aVariable=5 //side efect. In Scala, and in programming in general, we may have avoid side effects because it could generate
              //uncontrollable behaviours
  var anotherVariable = 6
}
