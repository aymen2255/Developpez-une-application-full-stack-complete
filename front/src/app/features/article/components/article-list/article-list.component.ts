import {Component, OnInit} from '@angular/core';
import {ArticleService} from "../../services/article.service";
import {ArticleResponse} from "../../interfaces/article.interface";

@Component({
  selector: 'app-article-list',
  templateUrl: './article-list.component.html',
  styleUrls: ['./article-list.component.scss']
})
export class ArticleListComponent implements OnInit {

  // public articles$: Observable<Articles> = this.articleService.all();
  articles: ArticleResponse[] = [];
  sortAscending: boolean = false; // Variable pour suivre l'ordre de tri

  constructor(private articleService: ArticleService) {
  }

  ngOnInit(): void {
    this.articleService.all().subscribe(response => {
      this.articles = response.articles;
      console.log(this.articles)
    });
  }

  sortArticles(): void {
    this.articles.sort((a, b) => {
      const dateA = new Date(a.created_at).getTime();
      const dateB = new Date(b.created_at).getTime();

      if (this.sortAscending) {
        return dateA - dateB;
      } else {
        return dateB - dateA;
      }
    });
    this.sortAscending = !this.sortAscending;
  }
}
