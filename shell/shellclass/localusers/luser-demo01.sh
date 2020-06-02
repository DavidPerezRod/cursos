#!/bin/bash

# This script displays various information to the screen.


# Display the text 'Hello'
echo 'Hello'

#Assing a value to a variable
WORD='script' 

#Disply that value using the variable
echo "$WORD"

#Demonstrate that single quotes cause variables to NOT get expanded
echo '$WORD'

# combine the variable with hard-coded text
echo "This is a shell $WORD"

# Display the contents of the variable using an alternative syntax
echo "This is a shell ${WORD}"

# Append text to the variable
echo "${WORD}ing is fun!" #este ejemplo es importante porque la shell no sabría interpretarlo sin el uso de llaves, ya que la variable no existiría

# Show hot NOT to append text to a variable. This doesn't work
echo "$WORDing is fun!"

# Create a new varible
ENDING='ed'

#Combine the two variblaes
echo "This is ${WORD}${ENDING}."

#Change the value stored in the ENDING variable. (Reassignment.)
ENDING='ing'

echo "This is ${WORD}${ENDING} is fun!"

#Reassing value to ENDING.
ENDING='S'
echo "You are going to write many ${WORD}${ENDING}  in this class!"
