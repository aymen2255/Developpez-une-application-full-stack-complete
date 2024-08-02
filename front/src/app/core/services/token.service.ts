import { Injectable } from '@angular/core';
import {JwtHelperService} from "@auth0/angular-jwt";
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class TokenService {

  private jwtHelper = new JwtHelperService();

  constructor(private router: Router) {}

  set token(token: string) {
    localStorage.setItem('token', token);
  }

  get token() {
    return localStorage.getItem('token') as string;
  }

  isTokenValid() {
    const token = this.token;
    if (!token) {
      return false;
    }

    // check expiry date
    const isTokenExpired = this.jwtHelper.isTokenExpired(token);
    if (isTokenExpired) {
      localStorage.clear();
      return false;
    }
    return true;
  }

  isTokenNotValid() {
    return !this.isTokenValid();
  }
  getUserIdFromToken(): string | null {
    const token = this.token;
    if (!token) {
      return null;
    }
    const decodedToken = this.jwtHelper.decodeToken(token);
    return decodedToken?.userId || null;
  }

  updateToken(newToken: string) {
    this.token = newToken;
  }

  logout() {
    // Supprimer le token JWT du localStorage
    localStorage.removeItem('token');

    // Rediriger l'utilisateur vers la page de connexion
    this.router.navigate(['/login']);
  }
}
