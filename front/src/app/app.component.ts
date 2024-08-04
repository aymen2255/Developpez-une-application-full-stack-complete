import {Component, OnInit} from '@angular/core';
import {TokenService} from "./core/services/token.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit  {
  isLoggedIn = false;

  constructor(private tokenService: TokenService) {
    // Vérifiez si l'utilisateur est connecté au chargement du composant
    this.isLoggedIn = this.tokenService.isTokenValid();
  }

  ngOnInit() {
    // S'abonner à l'état de connexion
    this.tokenService.isLoggedIn.subscribe((loggedIn: boolean) => {
      this.isLoggedIn = loggedIn;
    });
  }
}
