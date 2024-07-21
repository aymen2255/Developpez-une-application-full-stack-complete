import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ThemeListComponent} from "./components/theme-list/theme-list.component";


@NgModule({
  declarations: [
    ThemeListComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [
    ThemeListComponent
  ]
})
export class ThemeModule {
}
