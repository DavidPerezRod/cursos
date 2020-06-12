(() => {
  const avenger = {
    name: "Steve",
    key: "Captain America",
    power: "Drug",
  };

  const extract = ({ name, key, power }: any) => {
    console.log(`name inside function ${name}`);
    console.log(`key inside function ${key}`);
    console.log(`power inside function ${power}`);
  };

  const { name, key, power } = avenger;
  console.log("deconstructing object properties".toUpperCase());
  console.log(name);
  console.log(key);
  console.log(power);

  console.log("deconstructing object properties from functionparameters".toUpperCase());
  extract(avenger);

  const avengers: string[] = ["thor", "ironman", "spiderman"];

  //traditional form to access an array 
  console.log("extracting values in traditional way".toUpperCase());
  console.log(avengers[0]);
  console.log(avengers[1]);
  console.log(avengers[2]);

  const [martillo, hierro, arana] = avengers;  //this form extract all positions from array
  console.log("deconstructing array".toUpperCase());
  console.log(martillo);
  console.log(hierro);
  console.log(arana);

  const [, , red] = avengers; //this form extract only third position from array
  console.log("deconstructing array with only one position of array".toUpperCase());
  console.log(red);

  const extractArray = ([Thor, Ironman, Spiderman]: string []) => {
    console.log("deconstructing array from function parameters".toUpperCase());
    console.log(Thor);
    console.log(Ironman);
    console.log(Spiderman);
  }

})();
