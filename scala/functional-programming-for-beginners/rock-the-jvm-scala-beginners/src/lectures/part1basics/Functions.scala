package lectures.part1basics

object Functions extends App{

  def aFunction(aString: String, n:Int)= {
    if (n==1) aString
    else aString+aRepeatedFunction(aString, n-1)
  }

  println (aFunction("Hello", 3))

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())
  println(aParameterlessFunction)

  // when you need loops, use recursion1
  def aRepeatedFunction(aString: String, n:Int): String = {
    if (n==1) aString
    else aString+aRepeatedFunction(aString, n-1)
  }
  println(aRepeatedFunction("Hello", 3))

  //in block functions, compiler can infer function return type.
  def anotherFunction(a: String, b: Int)= {
    a + " " + b
  }
  // but compiler cant infer type in recursive functions
/*  def anotherRepeatedFunction(aString: String, n:Int)= {
    if (n==1) aString
    else aString+aRepeatedFunction(aString, n-1)
  }*/

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction (a: Int, b:Int): Int = a + b
    aSmallerFunction(n, n-1)
  }

  /*
    1. A greeting function (name, age) => "hi, my name is $name and I am $age years old"
    2. Factorial Function
    3. Fibonacci Function
     f(1) = 1
     f(2) = 1
     f(n) = f(n-1)+f(n-2)
     4. Test if a number is prime
   */

  def aGreetingFunction(name: String, age: Int): String ={
    "Hi, my name is "+ name +" and I am " + age + " years old"
  }

  println(aGreetingFunction("Noel", 16))

  def aFactorialFunction(base: Int): Int={
    if (base>1)
      base * aFactorialFunction(base-1)
    else
      base
  }
  println(aFactorialFunction(7))

  def aFibonnacciFunction(base: Int): Int ={
    if (base >2)
      aFibonnacciFunction(base-1) + aFibonnacciFunction(base-2)
    else
      1
  }

  println(aFibonnacciFunction(8))

  def aPrimeFunction(n: Int): Boolean={
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t-1)
    }
    isPrimeUntil(n/2)
  }
  println(aPrimeFunction(4))
}


