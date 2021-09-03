"use strict";
(function () {
    //function assigned to a variable
    var miFuncion = function (a) {
        return a;
    };
    //const function couldn't be overwritten
    var constFuncion = function (a) {
        return a;
    };
    //traditional function      
    function b(a) {
        return a;
    }
    //first arrow function format
    var arrowFunction = function (a) {
        return a;
    };
    //first arrow function format
    var secondArrowFunction = function (a) { return a.toUpperCase(); };
    //another example
    var sum = function (a, b) {
        return a + b;
    };
    var arrowSum = function (a, b) { return a + b; };
    var hulk = {
        nombre: 'Hulk',
        smash: function () {
            var _this = this;
            setTimeout(function () {
                console.log(_this.nombre + " smash!!!");
            }, 1000);
        }
    };
    hulk.smash();
})();
