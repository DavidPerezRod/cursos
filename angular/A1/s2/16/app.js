"use strict";
(function () {
    function activate(who, when, //optional argument
    object //argument with default value 
    ) {
        if (object === void 0) { object = "batise\u00F1al"; }
        if (when) {
            console.log(who + " activates the " + object + " that " + when);
        }
        else {
            console.log(who + " activates the " + object);
        }
    }
    activate("Gordon");
    activate("Gordon", "evening");
})();
