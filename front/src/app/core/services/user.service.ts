import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, tap} from "rxjs";
import {User} from "../interfaces/user.interface";
import {ArticleRequest} from "../../features/article/interfaces/article.interface";
import {AuthSuccess} from "../../features/auth/interfaces/authSuccess.interface";
import {TokenService} from "./token.service";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private pathService = 'api';

  constructor(
    private httpClient: HttpClient,
    private tokenService: TokenService
  ) {
  }

  public getUser(): Observable<User> {
    return this.httpClient.get<User>(`${this.pathService}/auth/me`);
  }

  public updateUser(user: User): Observable<AuthSuccess> {
    return this.httpClient.post<AuthSuccess>(`${this.pathService}/auth/me/update`, user).pipe(
      tap((newJwt: AuthSuccess) => {
        this.tokenService.updateToken(newJwt.token);// Mettre à jour le token dans le stockage local
      })
    );
  }
}
