import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ThemeService} from "../../../theme/services/theme.service";
import {Observable} from "rxjs";
import {Themes} from "../../../theme/interfaces/themes.interface";
import {ArticleService} from "../../services/article.service";
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatSnackBar} from "@angular/material/snack-bar";
import {Router} from "@angular/router";
import {Location} from "@angular/common";

@Component({
  selector: 'app-new-article',
  templateUrl: './new-article.component.html',
  styleUrls: ['./new-article.component.scss']
})
export class NewArticleComponent implements OnInit {

  articleForm!: FormGroup;
  themes$: Observable<Themes> = this.themeService.all();

  constructor(
    private fb: FormBuilder,
    private articleService: ArticleService,
    private themeService: ThemeService,
    private matSnackBar: MatSnackBar,
    private router: Router,
    private location: Location
  ) {
  }

  ngOnInit(): void {
    this.articleForm = this.fb.group({
      title: ['', [Validators.required, Validators.minLength(3)]],
      content: ['', [Validators.required]],
      themeId: ['', [Validators.required]]
    });
  }

  onSubmit(): void {
    if (this.articleForm.valid) {
      this.articleService.createArticle(this.articleForm.value).subscribe(response => {
        this.matSnackBar.open('Article créé', 'Close', { duration: 3000 });
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
