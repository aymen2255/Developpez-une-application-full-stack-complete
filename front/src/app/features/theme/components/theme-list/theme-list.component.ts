import { Component, OnInit } from '@angular/core';
import {Subject} from "rxjs";
import {ThemeService} from "../../services/theme.service";

@Component({
  selector: 'app-theme-list',
  templateUrl: './theme-list.component.html',
  styleUrls: ['./theme-list.component.scss']
})
export class ThemeListComponent implements OnInit {

  public themes$ = this.themeService.all();

  constructor(private themeService: ThemeService) {
  }

  ngOnInit(): void {
  }
}
