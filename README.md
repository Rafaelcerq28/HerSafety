# HerSafety

Final Project for Higher Diploma

### Endpoint to get/create/edit/delete a place

##### - Get
`http://localhost:8080/place/{name}`

`http://localhost:8080/place/id/{id}`

`http://localhost:8080/place/the+bernard+shaw`

`http://localhost:8080/place`

`http://localhost:8080/place?name=the+bernard+shaw`

##### - Get All
`http://localhost:8080/places`

##### - Put
`http://localhost:8080/place/{id}?name=Place+name`
##### - Delete
`http://localhost:8080/place/{id}`

----

### Endpoint to create/delete/get/update user

##### - Post (requestBody)
  `http://localhost:8080/users`

```
  {
  "username": "maria123",
  "password": "password1234",
  "name": "Maria Silva",
  "dateOfBirth": "1990-05-15",
  "email": "maria@example.com",
  "notifications": true
  } 
```

##### - Get all
  `http://localhost:8080/users`

##### - Get id)
  `http://localhost:8080/users/{id}`

##### - Put
  `http://localhost:8080/users/{id}`

##### - Delete
  `http://localhost:8080/users/{id}`

----

  ### Endpoint to create/delete/get/update a report

##### - Post
`http://localhost:8080/report`

```
    {
        "userId": 2,
        "placeId":1,
        "safety": 4,
        "welcoming": 5,
        "toilets": 3,
        "feminineProducts": 2,
        "illumination": 4,
        "crowdQuality": 3,
        "privacy": 4,
        "safetyInfo": 5,
        "comment": "O lugar é seguro, mas poderia melhorar na oferta de produtos femininos."
      }
```

##### - Get all by user

`http://localhost:8080/report/user/{userId}`

##### - Get all by place

`http://localhost:8080/report/place/{placeId}`

##### - Get by id
`http://localhost:8080/report/{Id}`

##### - Get All
`http://localhost:8080/report`

##### - Put
`http://localhost:8080/report/{id}`

```
{
  "id":4,
  "safety": 2,
  "welcoming": 3,
  "toilets": 5,
  "feminineProducts": 1,
  "illumination": 5,
  "crowdQuality": 3,
  "privacy": 4,
  "safetyInfo": 4,
  "comment": "new comment!"
}

```

##### - Delete
`http://localhost:8080/report/{Id}`

----

### Endpoint to Login / Logout

#### - Post - Login
`http://localhost:8080/login`

```
 {
  "username": "maria123",
  "password": "password123"
  } 
```

#### - Post - Logout
`http://localhost:8080/logout`

```
 {} 
```

----
Link for swagger:

http://localhost:8080/swagger-ui/index.html

----
# To Do:

### General
- Arrumar esse readme

### Spring
- filtrar a localização dos lugares e deixar o metodo funcionando 100% testar muito mas muito mesmo (IMPORTANTE 1 )
- checar/refatorar o metodo para pegar o place no google(IMPORTANTE 3 )
- comentar o codigo propriamente(IMPORTANTE 4)

### Angular
- fazer a pagina de admin (URGENTE)
- implementar o autocomplete do maps(IMPORTANTE 2)
- comentar o codigo propriamente(IMPORTANTE 4)

#E6E6FA

https://bootstrapmade.com/demo/Impact/

https://bootstrapmade.com/demo/Tempo/

https://bootstrapmade.com/demo/Regna/
