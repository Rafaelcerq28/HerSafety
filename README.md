# HerSafety

Final Project for Higher Diploma

### Endpoint to get/create place

- (get)
http://localhost:8080/place/{name}

http://localhost:8080/place/the+bernard+shaw


http://localhost:8080/place

http://localhost:8080/place?name=the+bernard+shaw

----

### Endpoint to create/delete/get/update user

- (post requestBody)
  http://localhost:8080/users

  {
  "username": "maria123",
  "password": "password1234",
  "name": "Maria Silva",
  "dateOfBirth": "1990-05-15",
  "email": "maria@example.com",
  "notifications": true
  } 

- (get all)
  http://localhost:8080/users

- (get id)
  http://localhost:8080/users/{id}

- (put id)
  http://localhost:8080/users/{id}

- (delete id)
  http://localhost:8080/users/{id}

----

  ### Endpoint to add a report

- (post)
http://localhost:8080/report


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