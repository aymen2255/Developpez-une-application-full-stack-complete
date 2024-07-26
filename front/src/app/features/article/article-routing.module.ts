import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ArticleListComponent} from "./components/article-list/article-list.component";

const routes: Routes = [
  {title: 'articles', path: '', component: ArticleListComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ArticleRoutingModule { }
