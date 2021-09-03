
1. creamos un red:

docker network create lab

2. descargamos y ejecutamos la imagen de MariaDB sobre la red creada:

docker run --net lab --name db01 -e MYSQL_ROOT_PASSWORD=password -d mariadb:latest

3. ejecutamos bash en el contenedor para inspeccionar sus variables de entorno

* docker exec -it db01 bash
* env

4. entramos en la BBDD

mysql -u root -ppassword

5. Ejecutar el contenedor, entrar y borrarlo una vez que salgamos, en un solo comando. (docker run --help explica los parámetros). La peculiaridad, es que levanta otro contenedor mariadb en el cual ejecuta el comando mysql contra la BBDD del host db01 con el usuario root. Esta misma estrategia puede utilizarse para coneectarse a otros host mysql que no sean docker.

* docker run -it --name test --network lab --rm mariadb mysql -hdb01 -uroot -p

6. Importar una BBDD mediante fichero de dump

* docker exec -i db01 sh -c 'exec mysql -uroot -p"$MYSQL_ROOT_PASSWORD"' < dump/users.sql
  * -i modo interactivo
  * -c es una opción de sh, que ya se ejecuta dentro del host db01
  * < indica la entrada desde el fichero