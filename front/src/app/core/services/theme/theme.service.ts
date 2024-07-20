import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';;
import { environment } from 'src/environments/environment';
import { Themes } from '../../interfaces/themes.interface';


@Injectable({
  providedIn: 'root'
})
export class ThemeService {

  private pathService = environment.baseUrl +'api/themes';
  constructor(private httpClient: HttpClient) { }

  public all(): Observable<Themes> {
    return this.httpClient.get<Themes>(this.pathService);
  }
}
