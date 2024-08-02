import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Theme} from "../../theme/interfaces/theme.interface";

@Injectable({
  providedIn: 'root'
})
export class SubscriptionService {

  private pathService = 'api';

  constructor(private httpClient: HttpClient) {
  }

  public getSubscribedThemes(): Observable<{ themes: Theme[] }> {
    return this.httpClient.get <{ themes: Theme[] }>(`${this.pathService}/subscribed-themes`);
  }
}
