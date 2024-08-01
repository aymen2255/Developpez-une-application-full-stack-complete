import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MatSnackBar} from "@angular/material/snack-bar";
import {Router} from "@angular/router";
import {User} from "../../interfaces/user.interface";
import {UserService} from "../../services/user.service";
import {TokenService} from "../../services/token.service";

@Component({
  selector: 'app-me',
  templateUrl: './me.component.html',
  styleUrls: ['./me.component.scss']
})
export class MeComponent implements OnInit {

  user!: User;
  userForm!: FormGroup;

  constructor(
    private fb: FormBuilder,
    private matSnackBar: MatSnackBar,
    private router: Router,
    private userService: UserService,
    private tokenService: TokenService
  ) {
  }

  ngOnInit(): void {
    this.userForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      username: ['', [Validators.required, Validators.min(3), Validators.maxLength(20)]],
    });
    this.getUserInfo();
  }

  getUserInfo(): void {
    this.userService.getUser().subscribe(
      data => {
        this.user = data;
        this.userForm.patchValue(this.user);
      },
      error => {
        console.error('Erreur lors de la récupération des informations de l\'utilisateur', error);
      }
    );
  }
  onLogout() {
    this.tokenService.logout();
  }

  public submit(): void {
  }

}
