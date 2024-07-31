import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ArticleListComponent} from "./components/article-list/article-list.component";
import {NewArticleComponent} from "./components/new-article/new-article.component";
import {DetailArticleComponent} from "./components/detail-article/detail-article.component";

const routes: Routes = [
  {title: 'articles', path: '', component: ArticleListComponent},
  {title: 'create article', path: 'create', component: NewArticleComponent},
  { title: 'Detail', path: 'detail/:id', component: DetailArticleComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ArticleRoutingModule { }
