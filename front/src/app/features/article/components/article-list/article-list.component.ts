import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import {ArticleService} from "../../services/article.service";
import {Articles} from "../../interfaces/articles.interface";

@Component({
  selector: 'app-article-list',
  templateUrl: './article-list.component.html',
  styleUrls: ['./article-list.component.scss']
})
export class ArticleListComponent implements OnInit {

  public articles$: Observable<Articles> = this.articleService.all();

  constructor(private articleService: ArticleService) {
  }

  ngOnInit(): void {
  }

}
