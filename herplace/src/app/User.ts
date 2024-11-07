export interface User{
    username: string;
    password:string;
    name:string;
    dateOfBirth: string;
    email: string;
    notifications: boolean;
    createdAt: string;
}

// GET EXAMPLE
// "username": "flavia",
// "name": "Flavia Damasceno",
// "dateOfBirth": "1990-05-15",
// "email": "flavia@example.com",
// "notifications": false,
// "createdAt": "2024-11-05T20:56:03.780082Z"
// "role": "USER"

//POST EXAMPLE
// {
//     "username": "joana",
//     "password": "password1234",
//     "name": "Joana Silva",
//     "dateOfBirth": "1990-05-15",
//     "email": "joana@example.com",
//     "createdAt": ""
//     "notifications": true
// } 