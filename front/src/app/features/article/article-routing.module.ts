import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ArticleListComponent} from "./components/article-list/article-list.component";
import {NewArticleComponent} from "./components/new-article/new-article.component";

const routes: Routes = [
  {title: 'articles', path: '', component: ArticleListComponent},
  {title: 'create article', path: 'create', component: NewArticleComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ArticleRoutingModule { }
