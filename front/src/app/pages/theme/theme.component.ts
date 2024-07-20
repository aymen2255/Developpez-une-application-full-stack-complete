import { Component, OnDestroy, OnInit } from '@angular/core';
import { Observable, of, Subject, takeUntil } from 'rxjs';
import { ThemeService } from 'src/app/core/services/theme/theme.service';

@Component({
  selector: 'app-theme',
  templateUrl: './theme.component.html',
  styleUrls: ['./theme.component.scss']
})
export class ThemeComponent implements OnInit, OnDestroy {

  private destroy$!: Subject<boolean>;
  
  public themes$ = this.themeService.all();

  constructor(private themeService: ThemeService) {
  }

  ngOnInit(): void {
  }

  ngOnDestroy(): void {
    this.destroy$.next(true);
  }
}
