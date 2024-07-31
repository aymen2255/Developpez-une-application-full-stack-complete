import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Articles} from "../interfaces/articles.interface";
import {Article} from "../interfaces/article.interface";

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  private pathService = 'api';

  constructor(private httpClient: HttpClient) {
  }

  public all(): Observable<{ articles: Article[] }> {
    return this.httpClient.get<{ articles: Article[] }>(`${this.pathService}/articles`);
  }

  public createArticle(article: Article): Observable<any> {
    return this.httpClient.post(`${this.pathService}/article/create`, article);
  }

  public getArticleById(id: number): Observable<Article> {
    return this.httpClient.get<Article>(`${this.pathService}/article/${id}`);
  }
}
