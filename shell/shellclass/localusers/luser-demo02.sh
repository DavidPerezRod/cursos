#!/bin/bash

# Display the UID and username of the user executing this script
# Display if the user is the root user or not

# Distplay the UID
echo "Your UID is ${UID}"

# Display the username
USER_NAME=$(id -un)
echo "Your username is ${USER_NAME}"

USER_NAME=`id -un`
echo "Your username is the same with different assignation sintax: ${USER_NAME}"

# Display if the user is the root user or not
if [[ "${UID}" -eq 0 ]]
then 
 echo 'You are root'
else
 echo 'Your are not root'
fi 

