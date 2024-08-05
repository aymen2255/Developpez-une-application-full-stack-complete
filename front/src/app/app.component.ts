import {Component, OnInit} from '@angular/core';
import {TokenService} from "./core/services/token.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit  {
  isLoggedIn = false;
  currentRoute!: string;

  constructor(
    private tokenService: TokenService,
    private router: Router
    ) {
    // Vérifiez si l'utilisateur est connecté au chargement du composant
    this.isLoggedIn = this.tokenService.isTokenValid();
    this.router.events.subscribe((event: any) => {
      if (event.url) {
        this.currentRoute = event.url;
      }
    });
  }

  ngOnInit() {
    this.tokenService.isLoggedIn.subscribe((loggedIn: boolean) => {
      this.isLoggedIn = loggedIn;
    });
  }
}
