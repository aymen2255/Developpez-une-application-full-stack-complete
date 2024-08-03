import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ThemeListComponent} from "./components/theme-list/theme-list.component";
import {ThemeRoutingModule} from './theme-routing.module';
import {MatCardModule} from "@angular/material/card";
import {MatButtonModule} from "@angular/material/button";

@NgModule({
  declarations: [
    ThemeListComponent
  ],
  imports: [
    CommonModule,
    ThemeRoutingModule,
    MatCardModule,
    MatButtonModule
  ],
  exports: [
    ThemeListComponent
  ]
})
export class ThemeModule {
}
