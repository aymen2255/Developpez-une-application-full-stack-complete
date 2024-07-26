import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Articles} from "../interfaces/articles.interface";

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  private pathService = 'api/articles';
  constructor(private httpClient: HttpClient) { }

  public all(): Observable<Articles> {
    return this.httpClient.get<Articles>(this.pathService);
  }
}
