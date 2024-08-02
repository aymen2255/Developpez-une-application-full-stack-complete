import {Component, OnInit} from '@angular/core';
import {Theme} from "../../../theme/interfaces/theme.interface";
import {SubscriptionService} from "../../services/subscription.service";

@Component({
  selector: 'app-subscription-list',
  templateUrl: './subscription-list.component.html',
  styleUrls: ['./subscription-list.component.scss']
})
export class SubscriptionListComponent implements OnInit {

  themes: Theme[] = [];

  constructor(private subscriptionService: SubscriptionService) {
  }

  ngOnInit(): void {
    this.subscriptionService.getSubscribedThemes().subscribe(response => {
      this.themes = response.themes;
      console.log(this.themes)
    });
  }

}
