
1. creamos una red:

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

7. Crear contenedor para aplicación web python a partir de dockerfile

```dockerfile
FROM ubuntu:18.04

#se añade todo el contenido del directorio en el que estamos al directorio /srv del contenedor
ADD . /srv

#actualizamos repositorio apt
RUN apt-get update

#intalamos python-pip y las librerías de desarrollo  en modo desantendido (-y)
RUN apt install python-pip libmysqlclient-dev python-dev -y

#instala los módulos o librerías indicados en el fichero
RUN pip install -r /srv/requirements.txt

#exponemos el puerto 5000 que es el que por defecto expone Flask (framework python)
EXPOSE 5000

#lanza la aplicación definida en el fichero app.py
CMD /usr/bin/python /srv/app.py
```

Una vez creado el contenedor, con el comando:

 docker build -t python .

ejecutamos la aplicación python sobre la BBDD creada anteriormente:

docker run --network lab -e db_host=db01 -e db_user=root -e MYSQL_ROOT_PASSWORD=password -e db_name=users --name python --rm -p 5000:5000 python:latest

se ejecuta en la misma red, y se le pasan las variables de entorno una a una. Además el contenedor se borrará una vez ejecutado, se publica el puerto 5000 y se ejecuta la imagen de python creada en el paso anterior.

8. Crear todo con docker compose

```yml
version: '3'
#hay dos servicios uno web y otro BBDD
services:
  web:
  #el contenedor web se va a construir a partir de lo que haya en el directorio app/
    build: app/
    ports:
      - "5000:5000"
    env_file:
      - db_variables.env #fichero con las variables de entorno de ddbb
      - web_variables.env #fichero con las variables web
  db:
  # en este caso no se crea a través de un dockerfile, se baja de docker-hub
    image: "mariadb:latest"
    env_file:
      - db_variables.env
  # en este caso se crea un volumen para importar la BBDD en el que se copia el contenido del directorio dump
    volumes:
      - ./dump/:/docker-entrypoint-initdb.d:ro
```

después haremos un docker-compose up, para levantar el contenedor creado, que arrancará las dos imágenes simultáneamente.