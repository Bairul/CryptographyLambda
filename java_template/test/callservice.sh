#!/bin/bash

# JSON object to pass to Lambda Function
passphrase="Bairu"
plaintext="thisisometext"
json={"\"name\"":"\"$passphrase\"","\"data\"":"\"$plaintext\""}

echo "Invoking Lambda function using AWS CLI for encryption"
time output=`aws lambda invoke --invocation-type RequestResponse --function-name kmac_encryption --region us-east-2 --payload $json /dev/stdout | head -n 1 | head -c -2 ; echo`
echo ""

echo "ENCRYPTION JSON RESULT:"
echo $output | jq
echo ""

cryptogram=$( echo $output | jq ".cryptogram" | cut -d'"' -f2 )
json2={"\"name\"":"\"$passphrase\"","\"data\"":"\"$cryptogram\""}

echo "Invoking Lambda function using AWS CLI for decryption"
time output2=`aws lambda invoke --invocation-type RequestResponse --function-name kmac_decryption --region us-east-2 --payload $json2 /dev/stdout | head -n 1 | head -c -2 ; echo`
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