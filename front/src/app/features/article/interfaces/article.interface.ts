import {Author} from "./author.interface";
import {CommentResponse} from "./comment.interface";
import {Theme} from "../../theme/interfaces/theme.interface";
import {User} from "../../../core/interfaces/user.interface";

export interface ArticleRequest {
  id: number,
  title: string;
  content: string,
  theme_title: string;
  themeId:number;
  }

export interface ArticleResponse {
  id: number,
  author: User,
  title: string;
  content: string,
  created_at: Date,
  updated_at: Date
  theme: Theme;
  comments: CommentResponse[];
}
