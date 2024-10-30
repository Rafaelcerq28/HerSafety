export interface Place {
    id: number;
    address: string;
    name: string;
    placeId: string;
    types: string[];
    lat: number;
    lng: number;
    createdAt: string; // pode ser Date se quiser manipulação de data no Angular
  }