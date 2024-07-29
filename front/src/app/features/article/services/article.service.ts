import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Articles} from "../interfaces/articles.interface";
import {Article} from "../interfaces/article.interface";

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  private pathService = 'api';
  constructor(private httpClient: HttpClient) { }

  public all(): Observable<Articles> {
    return this.httpClient.get<Articles>(`${this.pathService}/articles`);
  }

  public createArticle(article: Article): Observable<any> {
    return this.httpClient.post(`${this.pathService}/article/create`, article);
  }
}
