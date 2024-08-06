import {Component, OnDestroy, OnInit} from '@angular/core';
import {Observable, Subject, takeUntil} from "rxjs";
import {ArticleService} from "../../services/article.service";
import {ActivatedRoute, Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MatSnackBar} from "@angular/material/snack-bar";
import {ArticleResponse} from "../../interfaces/article.interface";
import {CommentRequest} from "../../interfaces/comment.interface";
import {Location} from "@angular/common";

@Component({
  selector: 'app-detail-article',
  templateUrl: './detail-article.component.html',
  styleUrls: ['./detail-article.component.scss']
})
export class DetailArticleComponent implements OnInit, OnDestroy {

  public article$!: Observable<ArticleResponse>;
  private id!: number;
  commentForm!: FormGroup;
  private destroy$ !: Subject<boolean>;

  constructor(
    private articleService: ArticleService,
    private router: Router,
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private matSnackBar: MatSnackBar,
    private location: Location
  ) {
  }

  ngOnInit(): void {
    this.destroy$ = new Subject<boolean>();
    this.id = +this.route.snapshot.paramMap.get('id')!;
    this.article$ = this.articleService.getArticleById(this.id);

    this.commentForm = this.fb.group({
      content: ['', [Validators.required]]
    });
  }

  ngOnDestroy(): void {
    this.destroy$.next(true);
  }

  onSubmit(): void {
    if (this.commentForm.valid) {
      const commentRequest: CommentRequest = {
        content: this.commentForm.value.content
      };
      this.articleService.addComment(this.id, commentRequest)
        .pipe(takeUntil(this.destroy$))
        .subscribe(response => {
        this.matSnackBar.open('Commentaire ajouté!', 'Close', {duration: 3000});
        this.router.navigate(['articles']);
      }, error => {
        console.error('Error creating article', error);
      });
    }
  }

  goBack(): void {
    this.location.back();
  }
}
