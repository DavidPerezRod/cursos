(function () {

    //function assigned to a variable
    let miFuncion = function(a: string){
        return a;
    }

    //const function couldn't be overwritten
    const constFuncion = function(a: string){
        return a;
    }
    
    //traditional function      
    function b( a: string){
        return a;
    }

    //first arrow function format
    const arrowFunction = (a: string) => {
        return a;
    }

    //first arrow function format
    const secondArrowFunction = (a: string) => a.toUpperCase();

    //another example
    const sum = function (a: number, b:number){
        return a+b;
    }
    
    const arrowSum = (a: number, b:number) => a + b;
    
    const hulk = {
        nombre: 'Hulk', 
        smash(){
            setTimeout(()=>{
                console.log(`${this.nombre} smash!!!`);
            }, 1000) 
        }
    }

    hulk.smash();
})();
