export interface Report{
    safety: number;
    welcoming: number;
    toilets: number;
    feminineProducts: number;
    illumination: number;
    crowdQuality: number;
    privacy: number;
    safetyInfo: number;
    comment: string;
    id: number;
    userId: number;
    placeId: number;
    createdAt: string;
}

// {
//     "safety": 4,
//     "welcoming": 5,
//     "toilets": 3,
//     "feminineProducts": 2,
//     "illumination": 4,
//     "crowdQuality": 3,
//     "privacy": 4,
//     "safetyInfo": 5,
//     "comment": "O lugar é seguro, mas poderia melhorar na oferta de produtos femininos.",
//     "id": 1,
//     "userId": 2,
//     "placeId": 1
//   }