import {User} from "../../../core/interfaces/user.interface";
import {Author} from "./author.interface";

export interface CommentResponse {
  id: number;
  content: string;
  authorName: string;
  author:Author,
  createdAt?: Date;
}

export interface CommentRequest {
  content: string
}
