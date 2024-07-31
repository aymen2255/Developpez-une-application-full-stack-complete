import {Author} from "./author.interface";
import {Comment} from "./comment.interface";

export interface Article {
  id: number,
  author: Author,
  title: string;
  content: string,
  created_at: Date,
  updated_at: Date
  theme_title: string;
  comments: Comment[];
  }
