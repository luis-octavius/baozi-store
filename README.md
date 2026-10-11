# Baozi Store
API REST to manage a fictional store that sells little chinese breads called Baozis. With this API you can manage products, clients and orders.

## Technologies
- Java 17
- Spring Boot and Data JPA
- MariaDB

## `/products`
### `POST /products`

Request: 
```json
{
	"name": "Baozi de Carne de Porco",	
	"price": 5.50,
	"stock": true
}
```

Response: 
```json
{
	"id": 3, 
	"name": "Baozi de Carne de Porco",
	"price": 5.50,
	"stock": true
}
```
### `GET /products/{id}`
 
```json
{
	"id": 3,
	"name": "Baozi de Carne de Porco",
	"price": 5.50,
	"stock": true
}
```

### `GET /products 

```json
[
	{
		"id": 3,
		"name": "Baozi de Carna de Porco",
		"price": 5.50,
		"stock": true
	},
]
```


### DELETE /products/{id}

```json
// /delete/3
// Returns 204 (No content)
```

## `clients`

### `POST /clients`

Request:
```json
{
	"name": "Luis5562188"
}
```

Response: 
```json
{
	"clientSince": "2026-10-10",
	"id": 2,
	"name": "Luis5562188"
}
```

### `GET /clients`

```json
[
	{
		"clientSince": "2026-10-10",
		"id": 2,
		"name": "Luis5562188"
	}
]
```

### `GET /clients/{id}`

```json
// /clients/1
{
	"clientSince": "2026-10-10",
	"id": 2,
	"name": "Luis5562188"
}
```

### `DELETE /clients/{id}`

```json
// clients/2
// Returns 204 (No content)
```

## `/orders`

### `POST /orders`

Request:
```json
{
	"client": { "id": 2 },
	"product": { "id": 3 },
	"quantity": 2
```

Response:
```json
{
    "client": {
        "clientSince": "2026-10-10",
        "id": 2,
        "name": "Luis5562188"
    },
    "id": 2,
    "product": {
        "id": 3,
        "name": "Baozi de Carne de Porco",
        "price": 5.50,
        "stock": true
    },
    "quantity": 10
}
```

### `GET /orders`

```json
[
    {
        "client": {
            "clientSince": "2026-10-10",
            "id": 2,
            "name": "Luis5562188"
        },
        "id": 2,
        "product": {
            "id": 3,
            "name": "Baozi de Carne de Porco",
            "price": 5.5,
            "stock": true
        },
        "quantity": 10
    }
]
```

### `GET /orders/{id}`

```json
{
    "client": {
        "clientSince": "2026-10-10",
        "id": 2,
        "name": "Luis5562188"
    },
    "id": 2,
    "product": {
        "id": 3,
        "name": "Baozi de Carne de Porco",
        "price": 5.5,
        "stock": true
    },
    "quantity": 10
}
```

### DELETE /orders/{id}

```json
// /delete/2
// Returns 204 (No content)
```
