# Shop Web Service Example

__To run with IntelliJ:__

⋅⋅* Click to run class 'ku.shop.ShopServiceApplication`

__To compile and run with Maven:__

```$ mvn spring-boot:run```

__To set tax calculator:__

⋅⋅* Default uses Thailand tax rate. If you need to change,
set environment variable `TAX_CITY`. For example,

```TAX_CITY=Thailand```

⋅⋅* You can choose tax cities among `Thailand`, `NY`, `CA`.
Please see class `ku.shop.service.ServiceConfig` for tax city configuration.

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
