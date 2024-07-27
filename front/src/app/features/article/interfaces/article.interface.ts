import {Theme} from "../../theme/interfaces/theme.interface";
import {User} from "../../../core/interfaces/user.interface";
import {Author} from "./author.interface";

export interface Article {
  id: number,
  author: Author,
  title: string;
  content: string,
  created_at: Date,
  updated_at: Date
  theme_title: string;
  }
