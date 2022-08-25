import {APP_INITIALIZER, NgModule} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HomeComponent } from './Components/home/home.component';
import {HttpClientModule} from '@angular/common/http';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { EditEmployeeComponent } from './Components/edit-employee/edit-employee.component';
import {RouterModule, Routes} from '@angular/router';
import { ModalComponent } from './Components/modal/modal.component';
import {FormsModule} from '@angular/forms';
import { KeycloakService } from 'keycloak-angular';
import { KeycloakAngularModule } from 'keycloak-angular';
import {initializer} from './utils/app-init';
const routes: Routes = [
  { path: '', redirectTo: 'employees', pathMatch: 'full' },
  { path: 'employees', component: HomeComponent },
  { path: 'employees/edit/:id', component: EditEmployeeComponent }
  ];


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    EditEmployeeComponent,
    ModalComponent
  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    HttpClientModule,
    KeycloakAngularModule,
    NgbModule,
    FormsModule
  ],
  providers: [
    {
      provide: APP_INITIALIZER,
      useFactory: initializer,
      deps: [ KeycloakService ],
      multi: true
    }],
  bootstrap: [AppComponent]
})
export class AppModule { }
