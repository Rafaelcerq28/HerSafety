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
- Check HATEOAS to turn the project in a Restful API(se der tempo)
- Generate recomendation using chat gpt(PRIORIDADE 2 )
- filtrar a localização dos lugares(IMPORTANTE)
- checar/refatorar o metodo para pegar o place no google(IMPORTANTE)
- comentar o codigo propriamente(IMPORTANTE)

### Angular

- place report form (colocar o username na interface report e fazer isso 
                    para a classe report no spring, tambem editar o metodo 
                    POST para /report/{username} para poder passar o username 
                    e o report como body)(PRIORIDADE 1 )
- corrigir o botão search na pagina do place(IMPORTANTE)
- implementar o autocomplete do maps(IMPORTANTE)
- comentar o codigo propriamente(IMPORTANTE)

#E6E6FA

https://bootstrapmade.com/demo/Impact/

https://bootstrapmade.com/demo/Tempo/

https://bootstrapmade.com/demo/Regna/
