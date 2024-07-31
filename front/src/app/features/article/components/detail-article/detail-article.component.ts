import {Component, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {Article} from "../../interfaces/article.interface";
import {ArticleService} from "../../services/article.service";
import {ActivatedRoute, Router} from "@angular/router";
import {FormBuilder} from "@angular/forms";

@Component({
  selector: 'app-detail-article',
  templateUrl: './detail-article.component.html',
  styleUrls: ['./detail-article.component.scss']
})
export class DetailArticleComponent implements OnInit {

  public article$!: Observable<Article>;
  private id!: number;


  constructor(
    private articleService: ArticleService,
    private router: Router,
    private fb: FormBuilder,
    private route: ActivatedRoute
  ) {
  }

  ngOnInit(): void {
    this.id = +this.route.snapshot.paramMap.get('id')!;
    this.article$ = this.articleService.getArticleById(this.id);
    // this.article$ = this.articleService.getArticleById(this.id);
    console.log('id ====>'+this.id);
    console.log(this.article$);
  }

}
