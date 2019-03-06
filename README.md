# Shop Web Service Example

__To run in IntelliJ:__

Click to run class ShopServiceApplication

__To compile and run:__

$ mvn spring-boot:run

__Possible calls:__

1. GET all products
	- http://localhost:8080/product/all

1. GET specific product with id
	- http://localhost:8080/product/{pid}
	- http://localhost:8080/product/1
	- http://localhost:8080/product/2
	- http://localhost:8080/product/3

2. POST order
    - http://localhost:8080/order/create/{productId}/{quantity}
    - http://localhost:8080/order/create/3/2

3. POST a product (create using json format)
	- http://localhost:8080/product/create

{
    "id": 5,
    "name": "Ham",
    "price": 60
}
