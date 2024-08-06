import {Component, OnDestroy, OnInit} from '@angular/core';
import {Theme} from "../../../theme/interfaces/theme.interface";
import {SubscriptionService} from "../../services/subscription.service";
import {MatSnackBar} from "@angular/material/snack-bar";
import {Subject, takeUntil} from "rxjs";

@Component({
  selector: 'app-subscription-list',
  templateUrl: './subscription-list.component.html',
  styleUrls: ['./subscription-list.component.scss']
})
export class SubscriptionListComponent implements OnInit, OnDestroy {

  themes: Theme[] = [];
  private destroy$ !: Subject<boolean>;

  constructor(
    private subscriptionService: SubscriptionService,
    private matSnackBar: MatSnackBar,
  ) {
  }

  ngOnInit(): void {
    this.destroy$ = new Subject<boolean>();
    this.subscriptionService.getSubscribedThemes()
      .pipe(takeUntil(this.destroy$))
      .subscribe(response => {
        this.themes = response.themes;
      });
  }

  ngOnDestroy(): void {
    this.destroy$.next(true);
  }

  unsubscribeUserFromTheme(themeId: number): void {
    this.subscriptionService.unsubscribeUserFromTheme(themeId).subscribe(
      response => {
        this.matSnackBar.open('Vous n\'êtes plus abonné!', 'Close', {duration: 3000});
        this.themes = this.themes.filter(t => t.id !== themeId);
      },
      error => {
        console.error('Erreur lors de l\'abonnement', error);
      }
    );
  }
}
