import {Component, OnInit} from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {AuthService} from "../../services/auth.service";
import {Router} from "@angular/router";
import {LoginRequest} from "../../interfaces/loginRequest.interface";
import {AuthSuccess} from "../../interfaces/authSuccess.interface";
import {TokenService} from "../../../../core/services/token.service";

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
    password: ['', [Validators.required, Validators.min(3)]]
  });

  constructor(private authService: AuthService,
              private fb: FormBuilder,
              private router: Router,
              private tokenService: TokenService) {
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


  // public submit(): void {
  //   const loginRequest = this.form.value as LoginRequest;
  //   this.authService.login(loginRequest).subscribe(
  //     (response: AuthSuccess) => {
  //       localStorage.setItem('token', response.token);
  //       this.authService.me().subscribe((user: User) => {
  //         this.sessionService.logIn(user);
  //         this.router.navigate(['/themes'])
  //       });
  //       this.router.navigate(['/themes'])
  //     },
  //     error => this.onError = true
  //   );
  // }

}
