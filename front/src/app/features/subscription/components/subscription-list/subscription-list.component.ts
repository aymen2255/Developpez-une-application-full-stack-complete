import {Component, OnInit} from '@angular/core';
import {Theme} from "../../../theme/interfaces/theme.interface";
import {SubscriptionService} from "../../services/subscription.service";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-subscription-list',
  templateUrl: './subscription-list.component.html',
  styleUrls: ['./subscription-list.component.scss']
})
export class SubscriptionListComponent implements OnInit {

  themes: Theme[] = [];

  constructor(
    private subscriptionService: SubscriptionService,
    private matSnackBar: MatSnackBar,
    ) {
  }

  ngOnInit(): void {
    this.subscriptionService.getSubscribedThemes().subscribe(response => {
      this.themes = response.themes;
      console.log(this.themes)
    });
  }

  unsubscribeUserFromTheme(themeId: number): void {
    console.log('themeid=======>'+themeId)
    this.subscriptionService.unsubscribeUserFromTheme(themeId).subscribe(
      response => {
        this.matSnackBar.open('Vous n\'êtes plus abonné!' , 'Close', { duration: 3000 });
        this.themes = this.themes.filter(t => t.id !== themeId);
        console.log('Abonnement réussi', response);
      },
      error => {
        console.error('Erreur lors de l\'abonnement', error);
      }
    );
  }
}
