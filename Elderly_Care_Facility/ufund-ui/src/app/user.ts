import {Need} from "./need";

export interface User {
  id: number;
  name: string;
  password: string;
  admin: boolean;
  cart: Need[];
}
