import {Component, OnInit} from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {AuthService} from "../../services/auth.service";
import {Router} from "@angular/router";
import {LoginRequest} from "../../interfaces/loginRequest.interface";
import {AuthSuccess} from "../../interfaces/authSuccess.interface";
import {TokenService} from "../../../../core/services/token.service";
import {Location} from "@angular/common";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  public hide = true;
  public onError = false;

  public form = this.fb.group({
    email: ['', [Validators.required, Validators.email]],
    password: ['', [Validators.required, Validators.min(8)]]
  });

  constructor(
    private authService: AuthService,
    private fb: FormBuilder,
    private router: Router,
    private tokenService: TokenService,
    private location: Location
  ) {
    if (this.tokenService.isTokenValid()) {
      this.router.navigate(['themes']);
    }
  }

  public submit(): void {
    const loginRequest = this.form.value as LoginRequest;

    this.authService.login(loginRequest).subscribe({
      next: (response: AuthSuccess) => {
        this.tokenService.token = response.token as string;
        this.router.navigate(['themes']);
      },
      error: (err) => {
        console.log(err);
        this.onError = true;
      }
    });
  }

  goBack(): void {
    this.location.back();
  }

}
