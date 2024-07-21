import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ThemeListComponent} from "./components/theme-list/theme-list.component";
import { ThemeRoutingModule } from './theme-routing.module';

@NgModule({
  declarations: [
    ThemeListComponent
  ],
  imports: [
    CommonModule,
    ThemeRoutingModule
  ],
  exports: [
    ThemeListComponent
  ]
})
export class ThemeModule {
}
