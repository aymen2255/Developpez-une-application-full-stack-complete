import {User} from "../../../core/interfaces/user.interface";

export interface CommentResponse {
  id: number;
  content: string;
  authorName: string;
  createdAt?: Date;
}

export interface CommentRequest {
  content: string
}
