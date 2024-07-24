import { Component, OnInit } from '@angular/core';
import {Observable, Subject} from "rxjs";
import {ThemeService} from "../../services/theme.service";
import {Theme} from "../../interfaces/theme.interface";
import {Themes} from "../../interfaces/themes.interface";

@Component({
  selector: 'app-theme-list',
  templateUrl: './theme-list.component.html',
  styleUrls: ['./theme-list.component.scss']
})
export class ThemeListComponent implements OnInit {

  public themes$: Observable<Theme[]> = this.themeService.all();

  constructor(private themeService: ThemeService) {
  }

  ngOnInit(): void {
  }
}
