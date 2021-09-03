(function () {
    function activate (who: string,
                        when?: String, //optional argument
                        object: string =`batiseñal` //argument with default value 
                        ){

        if (when){
            console.log(`${who} activates the ${object} that ${when}`);
        }else{
            console.log(`${who} activates the ${object}`);
        }


    }

    activate("Gordon")
    activate("Gordon", "evening");
})();
