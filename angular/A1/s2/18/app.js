"use strict";
(function () {
    var avenger = {
        name: "Steve",
        key: "Captain America",
        power: "Drug",
    };
    var extract = function (_a) {
        var name = _a.name, key = _a.key, power = _a.power;
        console.log("name inside function " + name);
        console.log("key inside function " + key);
        console.log("power inside function " + power);
    };
    var name = avenger.name, key = avenger.key, power = avenger.power;
    console.log("deconstructing object properties".toUpperCase());
    console.log(name);
    console.log(key);
    console.log(power);
    console.log("deconstructing object properties from functionparameters".toUpperCase());
    extract(avenger);
    var avengers = ["thor", "ironman", "spiderman"];
    //traditional form to access an array 
    console.log("extracting values in traditional way".toUpperCase());
    console.log(avengers[0]);
    console.log(avengers[1]);
    console.log(avengers[2]);
    var martillo = avengers[0], hierro = avengers[1], arana = avengers[2]; //this form extract all positions from array
    console.log("deconstructing array".toUpperCase());
    console.log(martillo);
    console.log(hierro);
    console.log(arana);
    var red = avengers[2]; //this form extract only third position from array
    console.log("deconstructing array with only one position of array".toUpperCase());
    console.log(red);
    var extractArray = function (_a) {
        var Thor = _a[0], Ironman = _a[1], Spiderman = _a[2];
        console.log("deconstructing array from function parameters".toUpperCase());
        console.log(Thor);
        console.log(Ironman);
        console.log(Spiderman);
    };
})();
