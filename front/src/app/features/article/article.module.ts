import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ArticleRoutingModule } from './article-routing.module';
import {ArticleListComponent} from "./components/article-list/article-list.component";
import {MatCardModule} from "@angular/material/card";
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from "@angular/material/button";
import { NewArticleComponent } from './components/new-article/new-article.component';
import {ReactiveFormsModule} from "@angular/forms";
import {MatSelectModule} from "@angular/material/select";
import {MatSnackBarModule} from "@angular/material/snack-bar";
import { DetailArticleComponent } from './components/detail-article/detail-article.component';
import {MatIconModule} from "@angular/material/icon";


@NgModule({
  declarations: [
    ArticleListComponent,
    NewArticleComponent,
    DetailArticleComponent
  ],
    imports: [
        CommonModule,
        ArticleRoutingModule,
        MatCardModule,
        MatInputModule,
        MatButtonModule,
        ReactiveFormsModule,
        MatSelectModule,
        MatSnackBarModule,
        MatIconModule
    ]
})
export class ArticleModule { }
