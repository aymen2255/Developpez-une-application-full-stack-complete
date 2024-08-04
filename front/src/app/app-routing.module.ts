import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from './pages/home/home.component';
import {AuthGuard} from "./core/guards/auth-guard";
import {MeComponent} from "./core/components/me/me.component";

// consider a guard combined with canLoad / canActivate route option
// to manage unauthenticated user to access private routes
const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'themes',
    loadChildren: () => import('./features/theme/theme.module').then((m => m.ThemeModule)),
    canActivate: [AuthGuard]
  },
  {
    path: 'articles',
    loadChildren: () => import('./features/article/article.module').then((m => m.ArticleModule)),
    canActivate: [AuthGuard]
  },
  {
    path: 'profile',
    canActivate: [AuthGuard],
    loadChildren: () => import('./features/profile/profile.module').then(m => m.ProfileModule)
  },
  {
    path: 'me',
    canActivate: [AuthGuard],
    component: MeComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {
}
