"use strict";
(function () {
    //tsc error. 123 is not assignalbe to type 'string'
    var variable1 = "Hola";
    variable1 = "123";
    //tsc error. "123" is not assignalbe to type number
    var variable2 = 123;
    variable2 = 123;
    //It could be verbose and innecesary. It has sense if we don't assign any value in its inizialitation
    var variable3 = "cadena";
    var variable4 = 123;
    var variable6 = true;
    var variable7 = new Date();
    //different situation. Variable5 hasn't been initialize and it's type going to be "any". 
    //But any, is a bad praxis. It admits any data type, and is a weak typing
    var variable5;
    variable5 = variable3;
    variable5 = variable4;
    variable5 = variable6;
    variable5 = variable7;
    //pipe for multiple types
    var variable8;
    variable8 = variable3;
    variable8 = variable4;
    //object types
    var spiderman = {
        name: "Peter",
        age: 30
    };
    spiderman = {
        name: "George",
        age: 45
    };
})();
