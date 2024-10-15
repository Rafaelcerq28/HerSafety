# HerSafety

Final Project for Higher Diploma

### Endpoint to get/create/edit/delete a place

##### - Get

`http://localhost:8080/place/{name}`

`http://localhost:8080/place/the+bernard+shaw`


`http://localhost:8080/place`

`http://localhost:8080/place?name=the+bernard+shaw`

##### - Put

##### - Delete

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

`http://localhost:8080/report/user/2`

##### - Get all by place

`http://localhost:8080/report/place/1`

##### - Get by id

##### - Put

##### - Delete