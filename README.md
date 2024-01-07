# Digital Wallet API

## Overview

This Digital Wallet API, written in Kotlin with Spring Boot, provides a secure and efficient way to manage digital transactions. It supports wallet creation, depositing, and withdrawing funds, with a focus on handling concurrent requests safely.

## Features

* Wallet creation
* Depositing and withdrawing funds
* Listing transactions

## Usage

### Installation

1. Clone the repository

```
git clone https://github.com/tiemenv/digitalwallet
```

2. Navigate to the repository

```
cd digitalwallet
```

### Starting the application

1. Run the dockerized PostgreSQL environment

```
docker-compose up -d
```

2. Run the application

```
./gradlew bootRun
```

By default, the application runs on port 9000. This can be modified in the `application.yml`

### Using the application

The application exposes 3 endpoints and seeds the database with some predefined users and a wallet.

You should start by adding a wallet for one of these users:

```
POST localhost:9000/wallet
Content-Type: application/json

{
  "userId": "47ca1b10-b7c1-420e-a9f1-ec7ab24087b0",
  "currency": "GBP"
}
```

We can now add funds to the wallet, for ease of testing, there is a preseeded wallet with the id `394e4b81-691b-4561-b3c7-c7d2e0c9c794`

```
POST localhost:9000/transaction
Content-Type: application/json

{
  "walletId": "394e4b81-691b-4561-b3c7-c7d2e0c9c794",
  "currency": "GBP",
  "amount": 1000,
  "type": "CREDIT"
}
```

Note that deposited funds should be between `10` and `10,000` GBP

You can withdraw funds from the same wallet

```
POST localhost:9000/transaction
Content-Type: application/json

{
  "walletId": "394e4b81-691b-4561-b3c7-c7d2e0c9c794",
  "currency": "GBP",
  "amount": 500,
  "type": "DEBIT"
}
```

Note that you can't withdraw more than `5,000` GBP at a time, and never more than what is in your wallet

You can consult a list of transactions:

```
GET localhost:9000/transactions?walletId=394e4b81-691b-4561-b3c7-c7d2e0c9c794
```

## Improvements to be made with more time

* There is no pagination yet, we can achieve this with the `Pageable` method parameter in the controller method
* Concurrency protection is very primitive and prone to forever locks
* Debiting/crediting the actual wallet amount and writing down the transaction should be atomic, one should never happen without the other. At the moment, it's possible for a wallet amount to change while no transaction gets written if something goes wrong inbetween the 2 methods.
* Unit and integration tests should be added
* Swagger should be better documented