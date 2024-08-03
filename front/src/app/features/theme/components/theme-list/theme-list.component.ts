import { Component, OnInit } from '@angular/core';
import {Observable, Subject} from "rxjs";
import {ThemeService} from "../../services/theme.service";
import {Themes} from "../../interfaces/themes.interface";
import {Theme} from "../../interfaces/theme.interface";
import {SubscriptionService} from "../../../subscription/services/subscription.service";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-theme-list',
  templateUrl: './theme-list.component.html',
  styleUrls: ['./theme-list.component.scss']
})
export class ThemeListComponent implements OnInit {

  themes: Theme[] = [];

  constructor(
    private themeService: ThemeService,
    private subscriptionService: SubscriptionService,
    private matSnackBar: MatSnackBar,
    ) {
  }

  ngOnInit(): void {
    this.themeService.all().subscribe(response => {
      this.themes = response.themes;
    });
  }

  subscribe(themeId: number): void {
    console.log('themeid=======>'+themeId)
    this.subscriptionService.subscribeToTheme(themeId).subscribe(
      response => {
        this.matSnackBar.open('Article créé', 'Close', { duration: 3000 });
        this.updateThemeSubscriptionStatus(themeId, true);
        console.log('Abonnement réussi', response);
      },
      error => {
        console.error('Erreur lors de l\'abonnement', error);
      }
    );
  }

  private updateThemeSubscriptionStatus(themeId: number, isSubscribed: boolean): void {
    const theme = this.themes.find(t => t.id === themeId);
    if (theme) {
      theme.subscribed = isSubscribed;
    }
  }
}
