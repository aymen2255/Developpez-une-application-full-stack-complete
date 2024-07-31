import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {CommentRequest} from "../interfaces/comment.interface";
import {ArticleRequest, ArticleResponse} from "../interfaces/article.interface";

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  private pathService = 'api';

  constructor(private httpClient: HttpClient) {
  }

  public all(): Observable<{ articles: ArticleResponse[] }> {
    return this.httpClient.get<{ articles: ArticleResponse[] }>(`${this.pathService}/articles`);
  }

  public createArticle(article: ArticleRequest): Observable<ArticleRequest> {
    return this.httpClient.post<ArticleRequest>(`${this.pathService}/article/create`, article);
  }

  public getArticleById(id: number): Observable<ArticleResponse> {
    return this.httpClient.get<ArticleResponse>(`${this.pathService}/article/${id}`);
  }

  public addComment(id: number, commentRequest: CommentRequest): Observable<CommentRequest> {
    return this.httpClient.post<CommentRequest>(`${this.pathService}/comment/add/${id}`, commentRequest);
  }
}
