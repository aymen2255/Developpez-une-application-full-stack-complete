import {Component, OnDestroy, OnInit} from '@angular/core';
import {ArticleService} from "../../services/article.service";
import {ArticleResponse} from "../../interfaces/article.interface";
import {Subject, takeUntil} from "rxjs";

@Component({
  selector: 'app-article-list',
  templateUrl: './article-list.component.html',
  styleUrls: ['./article-list.component.scss']
})
export class ArticleListComponent implements OnInit, OnDestroy {

  articles: ArticleResponse[] = [];
  sortAscending: boolean = false; // Variable pour suivre l'ordre de tri
  private destroy$ !: Subject<boolean>;

  constructor(private articleService: ArticleService) {
  }

  ngOnInit(): void {
    this.destroy$ = new Subject<boolean>();
    this.articleService.all()
      .pipe(takeUntil(this.destroy$))
      .subscribe(response => {
        this.articles = response.articles;
      });
  }

  ngOnDestroy(): void {
    this.destroy$.next(true);
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
