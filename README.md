# KMACXOF256 with AWS Lambda

This project combines core materials from my 2 classes: TCSS 462 Cloud Computing and TCSS 487 Cryptography. The goal is to have the encryption/decryption function of KMACXOF256 in 2 AWS Lambda functions. The output will be the cryptogram for the encryption and plaintext for the decryption of the data sent to the corresponding Lambda function.

KMACXOF256 stands for "Keccak Message Authentication Code eXtensible-Output Function 256." It is a specific instance of the KMAC construction, designed to produce an extendable-output function (XOF) with a fixed output length of 256 bits security.

Two REST API Gateway urls is created for the 2 Lambda functions.

**ACKNOWLEDGEMENT**

This project is made using a template from my Cloud Computing professor, Wes Lloyd. His [Github Repo](https://github.com/wlloyduw/SAAF). 

This material is based upon work supported by the National Science Foundation under Grant Number ([OAC-1849970](https://www.nsf.gov/awardsearch/showAward?AWD_ID=1849970&HistoricalAwards=false)).

Any opinions, findings, and conclusions or recommendations expressed in this material are those of the author(s) and do not necessarily reflect the views of the National Science Foundation.

License
=======
    Copyright 2022 Wes Lloyd - Serverless Application Analytics Framework (SAAF)

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
