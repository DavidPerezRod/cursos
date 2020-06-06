(function () {

    const name = "Fernando";
    const surname = "Herrera";
    const age = 33;        

    function getAge(){
        return age - 10;
    }

    //the simple way to concatenate literals
    const output= name + "\n" +  surname + "\n (" + age + ") "; 

    //output with templates
    let output2 = `${name} ${surname} (${age + 5}) \nreal age: ${getAge()}`;

    console.log("output without templates");
    console.log(output);     
    console.log();
    console.log("output with templates");
    console.log(output2);     
})();
