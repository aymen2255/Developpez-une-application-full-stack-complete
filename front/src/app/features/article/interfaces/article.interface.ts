import {Theme} from "../../theme/interfaces/theme.interface";
import {User} from "../../../core/interfaces/user.interface";

export interface Article {
  id: number,
  author: string,
  title: string;
  content: string,
  createdAt: Date,
  updatedAt: Date
  theme_title: string;
  }
