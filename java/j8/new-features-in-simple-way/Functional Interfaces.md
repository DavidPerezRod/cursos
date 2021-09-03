
La interfz funcional es un concepto introducido en java8 y que se caracteriza porque:

* solo puede declarar un método abstracto
* puede declarar cualquier número de métodos por defecto
* puede declarar cualquier número de métodos estáticos.

Las interfaces funcioanles pueden declararse por medio de la anotación @FunctionalInterface o bien puede ser inferida por el compilador. Sin embargo hay que tener en cuenta algunas consideraciones:
* Si la interfaz funcional se declara por medio de la anotación, el compilardor dara un error de compilación en la clase de interfaz cada vez que se viole el contrato.
* por el contrario, si se construye una interfaz que respeta el contrato de interfaz funcional, el compilador la tratará como tal y:
    * se podrán implementar expresiones lambda sobre la interfaz
    * si se escribe más de un método abstracto, la clase de interfaz seguirá siendo válida, pero ya no será una interfaz funcional y las expresiones lambda declaradas para implementar el primer método abstracto fallarán en compilación.
* algunos ejemplos sencillos
   * [ejemplo correcto](https://github.com/DavidPerezRod/cursos/blob/feature/j8/java/j8/new-features-in-simple-way/fuentes/functionalInterfaces/src/main/java/com/java8/functionalInterface/functionalInterfaces/FunctionalInterfaceExample.java)
   * [ejemplo incorrecto](https://github.com/DavidPerezRod/cursos/blob/feature/j8/java/j8/new-features-in-simple-way/fuentes/functionalInterfaces/src/main/java/com/java8/functionalInterface/functionalInterfaces/FunctionalInterfaceErrorExample.java)
* herencia e interfaces funcionales
   * Si una interfaz hereda de una interfaz funcional y no implementa ningún método abstracto adicional, sigue siendo una interfaz funcional.[ejemplo](https://github.com/DavidPerezRod/cursos/blob/feature/j8/java/j8/new-features-in-simple-way/fuentes/functionalInterfaces/src/main/java/com/java8/functionalInterface/functionalInterfaces/FunctionalInterfaceInheritExampleKO1.java)
   * Si la clase base define exactamente el mismo método abstracto que la clase padre, sigue siendo un interfaz funcional. [ejemplo](https://github.com/DavidPerezRod/cursos/blob/feature/j8/java/j8/new-features-in-simple-way/fuentes/functionalInterfaces/src/main/java/com/java8/functionalInterface/functionalInterfaces/FunctionalInterfaceInheritExampleOK2.java)
   * En la interfaz hija no se puede definir ningún nuevo método abstracto, de lo contrario se obtiene un error de compilación. [ejemplo](https://github.com/DavidPerezRod/cursos/blob/feature/j8/java/j8/new-features-in-simple-way/fuentes/functionalInterfaces/src/main/java/com/java8/functionalInterface/functionalInterfaces/FunctionalInterfaceInheritExampleKO1.java)
   * Cualquier interfaz no funcional, puede heredar la interfaz funcional y declarar otros métodos abstractos. [ejemplo](https://github.com/DavidPerezRod/cursos/blob/feature/j8/java/j8/new-features-in-simple-way/fuentes/functionalInterfaces/src/main/java/com/java8/functionalInterface/functionalInterfaces/FunctionalInterfaceInheritExamploOK3.java)
* El principal uso de las interfaces funcionales es declarar el punto de implementación de las expresiones lambda
   * [ejemplo 1](https://github.com/DavidPerezRod/cursos/blob/feature/j8/java/j8/new-features-in-simple-way/fuentes/functionalInterfaces/src/main/java/com/java8/functionalInterface/functionalInterfaces/LambdaExpresionExample1.java)
   * [ejemplo 2](https://github.com/DavidPerezRod/cursos/blob/feature/j8/java/j8/new-features-in-simple-way/fuentes/functionalInterfaces/src/main/java/com/java8/functionalInterface/functionalInterfaces/LambdaExpresionExample2.java)
   * [ejemplo 3](https://github.com/DavidPerezRod/cursos/blob/feature/j8/java/j8/new-features-in-simple-way/fuentes/functionalInterfaces/src/main/java/com/java8/functionalInterface/functionalInterfaces/LambdaExpresionExample3.java)
   * [ejemplo 4](https://github.com/DavidPerezRod/cursos/blob/feature/j8/java/j8/new-features-in-simple-way/fuentes/functionalInterfaces/src/main/java/com/java8/functionalInterface/functionalInterfaces/LambdaExpresionExample4.java)
   * [ejemplo 5 - runnable functional interface](https://github.com/DavidPerezRod/cursos/blob/feature/j8/java/j8/new-features-in-simple-way/fuentes/functionalInterfaces/src/main/java/com/java8/functionalInterface/functionalInterfaces/ThreadDemo.java)
