# Exchange-Service
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [Examples](#setup)
* [Author](#author)


## General info
This project is simple Currency Exchange app which can exchange given amount and currency into the requested one.

Additional to this project there is gateway api available on this address:
https://github.com/wbogdal/Gateway-Service
	
## Technologies
Project is created with:
* Spring Boot
* Java 11
	
## Setup
To build this project execute:

* git clone https://github.com/wbogdal/Exchange-Service.git
* cd currencyExchange
* mvn install

then to run execute:

* cd target
* java -jar currency-exchange-platform-0.0.1-SNAPSHOT.jar


## Examples
* Example link to get exchanged currency
http://localhost:8084/api/v1/exchange/123/EUR/PLN

* Example json with response
{
    "amount": 573.566097,
    "currency": "PLN"
}

Please note that provided free api key can only handle 300 requests per month. You can get your free api key here - https://currencyapi.com/

## Author
* Wojciech Bogdał
