import {NgModule} from '@angular/core';
import {MatButtonModule} from '@angular/material/button';
import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HomeComponent} from './pages/home/home.component';
import {HTTP_INTERCEPTORS, HttpClient, HttpClientModule} from '@angular/common/http';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon'
import {CoreModule} from "./core/core.module";
import {ThemeModule} from "./features/theme/theme.module";
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatListModule} from "@angular/material/list";
import {AuthModule} from "./features/auth/auth.module";
import {HttpTokenInterceptor} from './core/interceptors/http-token-interceptor';
import {ArticleModule} from "./features/article/article.module";

@NgModule({
  declarations: [AppComponent, HomeComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    HttpClientModule,
    MatToolbarModule,
    MatIconModule,
    CoreModule,
    ThemeModule,
    MatSidenavModule,
    MatListModule,
    AuthModule,
    ArticleModule
  ],
  providers: [
    HttpClient,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpTokenInterceptor,
      multi: true
    },

  ],
  bootstrap: [AppComponent],
})
export class AppModule {
}
