import {User} from "../../../core/interfaces/user.interface";

export interface Comment {
  id: number,
  auteur: User,
  content: string
}
