import {Component, OnInit} from '@angular/core';
import {KeycloakService} from 'keycloak-angular';
import {KeycloakProfile} from 'keycloak-js';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent  implements OnInit {
  title = 'omniApp1Front';
  profile: KeycloakProfile = {};
  isLoggedIn = false;
  constructor(public  keycloak: KeycloakService) {
  }

  ngOnInit(): void {
    this.keycloak.loadUserProfile().then(profile => {
    this.profile = profile;
    });
    this.keycloak.isLoggedIn().then(isLogged => {
      this.isLoggedIn = isLogged;
    });
  }
}
