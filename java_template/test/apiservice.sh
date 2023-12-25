#!/bin/bash

# JSON object to pass to Lambda Function
passphrase="Bairu"
plaintext="thisisometext"
json={"\"name\"":"\"$passphrase\"","\"data\"":"\"$plaintext\""}

echo "Invoking Lambda function using API Gateway for encryption"
time output=`curl -s -H "Content-Type: application/json" -X POST -d $json https://zlcxfgjnx6.execute-api.us-east-2.amazonaws.com/kmac-enc`
echo ""

echo "ENCRYPTION JSON RESULT:"
echo $output | jq
echo ""

cryptogram=$( echo $output | jq ".cryptogram" | cut -d'"' -f2 )
json2={"\"name\"":"\"$passphrase\"","\"data\"":"\"$cryptogram\""}

echo "Invoking Lambda function using API Gateway for decryption"
time output2=`curl -s -H "Content-Type: application/json" -X POST -d $json2 https://imeqpy3wic.execute-api.us-east-2.amazonaws.com/kmac-dec`
echo ""

echo "DECRPTION JSON RESULT:"
echo $output2 | jq
echo ""

deciphered=$( echo $output2 | jq ".decipheredText" | cut -d'"' -f2 )
accepted=$( echo $output2 | jq ".accept")

if [ "$accepted" -eq "1" ]
then 
    echo "Decyrption success!"
    echo "Message: $deciphered"
else
    echo "Decryption failed!"
fi