# Rewards Program to its Customers,
A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent over $50 in each transaction
(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).

## Tech Stack
| Technology | Version | Purpose |
| ------ | ------ | ------ |
| Java | 11| Programming Language |
| SpringBoot | 2.4.3 | Application Framework |
| H2 database |  | to store dataset |
| Embedded Tomcat Server | 9 | To Deploy Application |
| Maven |   | Build Tool |
| Swagger  | 3 | API Dcoumentaion and Testing |
| Junit, Mockito | 5 | Unit Test Cases |
| Log4j | 2.1.3 | To maintain Logs |

here i used H2 inline memory database by default i'm inserting some data related to last 4 months trasnactions data

## Rest Apis Info
created 3 apis 2 for fetching trasnactions list. another to add trasnactions

##### Request: GET - getReawrdsper3Months
http://localhost:8080/getReawrdsper3Months
##### Response:
[{"id":11,"price":120,"custid":1,"rewards":90,"transactiondate":"2022-07-23"},{"id":13,"price":450,"custid":750,"rewards":90,"transactiondate":"2022-05-17"}]

##### Request: GET - getAllTransactions
http://localhost:8080/getAllTransactions
##### Response:
[{"id":11,"price":120,"custid":1,"rewards":90,"transactiondate":"2022-07-23"},{"id":13,"price":450,"custid":750,"rewards":90,"transactiondate":"2022-05-17"}]

##### Request: POST - addTransaction
http://localhost:8080/addTransaction

##### Response Body:
{"custId":1,"purchasedPrice":120}
##### Response:
{"id":1,"price":120,"custid":1,"rewards":90}

##### swagger url:
http://localhost:8080/swagger-ui.html

![swagger](https://user-images.githubusercontent.com/53008196/126843059-c0bbf562-86d3-403b-be50-b6661bbe6665.JPG)

```sh
getReawrdsper3Months API Response
```
![response](https://user-images.githubusercontent.com/53008196/126843080-cc38f150-eb42-4730-858a-76a3f7efa4d5.JPG)


```sh
Test Cases Results
```
![test-cases](https://user-images.githubusercontent.com/53008196/126843101-10633e34-d6e1-431e-ad8e-228cee638ff1.JPG)
```sh
Code Coverage
```
![code-coverage](https://user-images.githubusercontent.com/53008196/126843126-fdb3d246-f2d2-4733-a217-80a3178ac133.JPG)
