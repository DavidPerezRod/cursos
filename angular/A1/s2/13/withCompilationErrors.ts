(function () {
//   //tsc error. 123 is not assignalbe to type 'string'
//   let variable1 = "Hola";
//   variable1 = 123;

//   //tsc error. "123" is not assignalbe to type number
//   let variable2 = 123;
//   variable2 = "123";

//   //It could be verbose and innecesary. It has sense if we don't assign any value in its inizialitation
//   let variable3: string = "cadena";
//   let variable4: number = 123;
//   let variable6: boolean= true;
//   let variable7: Date= new Date();

//   //But any, is a bad praxis. It admits any data type, and is a weak typing
//   let variable5;
//   variable5=variable3;

//   variable5=variable4;
//   variable5=variable6;
//   variable5=variable7;

//   //pipe for multiple types
//   let variable8: string | number;
//   variable8=variable3;
//   variable8=variable4;
//   variable8=variable6;
//   variable8=variable7;

//   //object types
//   let spiderman = {
//       name: "Peter",
//       age: 30
//   };

//   spiderman = {
//       name: "George",
//       age: 45
//   }
//   //now spiderman doesn't accept new object definition
//   spiderman = {};

//   spiderman = {
//     name: "George",
//     age: '45'
// }

})();
