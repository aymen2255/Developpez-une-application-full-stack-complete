import {Component, OnDestroy, OnInit} from '@angular/core';
import {Observable, Subject, takeUntil} from "rxjs";
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
export class ThemeListComponent implements OnInit, OnDestroy {

  themes: Theme[] = [];
  private destroy$ !: Subject<boolean>;

  constructor(
    private themeService: ThemeService,
    private subscriptionService: SubscriptionService,
    private matSnackBar: MatSnackBar,
  ) {
  }

  ngOnInit(): void {
    this.destroy$ = new Subject<boolean>();
    this.themeService.all()
      .pipe(takeUntil(this.destroy$))
      .subscribe(response => {
        this.themes = response.themes;
      });
  }

  ngOnDestroy(): void {
    this.destroy$.next(true);
  }

  subscribe(themeId: number): void {
    this.subscriptionService.subscribeToTheme(themeId)
      .pipe(takeUntil(this.destroy$))
      .subscribe(
      response => {
        this.matSnackBar.open('Article créé', 'Close', {duration: 3000});
        this.updateThemeSubscriptionStatus(themeId, true);
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
