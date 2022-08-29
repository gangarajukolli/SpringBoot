**Title:** Reward points calculation service based on the customer transactions

**Description:** Implemented in the SpringBoot, which will calculate the reward points for any given customer list

**Unit Tests:** Please use below class to run unit tests
RewardsprogramApplicationTests.java

**Health Check:**
**URL:** [http://localhost:8080/actuator/health](http://localhost:8080/actuator/health)

**Service End Point:**
**URL:** [http://localhost:8080/api/calculateRewards](http://localhost:8080/calculateRewards)

**Method:** POST

**Sample Request:** Expecting to provide list of customer details with one or more transactions

[
 {
  "customerId": "cust1",
  "customerName": "raju",
  "dateOfBirth": "2022-08-28T00:30:27.213Z",
  "location": "ca",
  "transactions": [
    {
      "transactionDate": "2022-07-28T00:30:27.213Z",
      "transactionId": "tran1",
      "transactionVale": 70
    },
    {
      "transactionDate": "2022-08-28T00:30:27.213Z",
      "transactionId": "tran1",
      "transactionVale": 100
    },
    {
      "transactionDate": "2022-08-28T00:30:27.213Z",
      "transactionId": "tran1",
      "transactionVale": 20
    }
  ]
},
 {
  "customerId": "cust2",
  "customerName": "Amar",
  "dateOfBirth": "2022-08-28T00:30:27.213Z",
  "location": "ca",
  "transactions": [
    {
      "transactionDate": "2022-07-28T00:30:27.213Z",
      "transactionId": "tran1",
      "transactionVale": 70
    },
    {
      "transactionDate": "2022-07-28T00:30:27.213Z",
      "transactionId": "tran1",
      "transactionVale": 100
    },
    {
      "transactionDate": "2022-08-28T00:30:27.213Z",
      "transactionId": "tran1",
      "transactionVale": 500
    }
  ]
}
]

**Sample Response:**
[
  {
    "customerId": "cust1",
    "customerName": "raju",
    "points": [
      {
        "month": "AUGUST",
        "ponts": 90
      },
      {
        "month": "JULY",
        "ponts": 20
      }
    ]
  },
  {
    "customerId": "cust2",
    "customerName": "Amar",
    "points": [
      {
        "month": "AUGUST",
        "ponts": 850
      },
      {
        "month": "JULY",
        "ponts": 190
      }
    ]
  }
]
