import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ArticleRoutingModule } from './article-routing.module';
import {ArticleListComponent} from "./components/article-list/article-list.component";
import {MatCardModule} from "@angular/material/card";
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from "@angular/material/button";


@NgModule({
  declarations: [
    ArticleListComponent
  ],
  imports: [
    CommonModule,
    ArticleRoutingModule,
    MatCardModule,
    MatInputModule,
    MatButtonModule
  ]
})
export class ArticleModule { }
