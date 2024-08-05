import {Component, OnInit} from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {AuthService} from "../../services/auth.service";
import {Router} from "@angular/router";
import {RegisterRequest} from "../../interfaces/registerRequest.interface";
import {AuthSuccess} from "../../interfaces/authSuccess.interface";
import {TokenService} from "../../../../core/services/token.service";
import {Location} from "@angular/common";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {

  public hide = true;
  public onError = false;
  private passwordRegex = /^(?=[^A-Z]*[A-Z])(?=[^a-z]*[a-z])(?=.*[@$!%*#?&^_-])(?=\D*\d).{8,}$/;

  public form = this.fb.group({
    email: ['', [Validators.required, Validators.email]],
    username: ['', [Validators.required, Validators.min(3), Validators.maxLength(20)]],
    password: ['', [Validators.required, Validators.min(8), Validators.maxLength(20), Validators.pattern(this.passwordRegex)]]
  });

  constructor(private authService: AuthService,
              private fb: FormBuilder,
              private tokenService: TokenService,
              private router: Router,
              private location: Location) {
    if (this.tokenService.isTokenValid()) {
      this.router.navigate(['themes']);
    }
  }

  public submit(): void {
    const registerRequest = this.form.value as RegisterRequest;
    this.authService.register(registerRequest).subscribe(
      (response: AuthSuccess) => {
        this.tokenService.token = response.token as string;
        this.router.navigate(['/themes']);
      },
      error => this.onError = true
    );
  }
  goBack(): void {
    this.location.back();
  }
}
