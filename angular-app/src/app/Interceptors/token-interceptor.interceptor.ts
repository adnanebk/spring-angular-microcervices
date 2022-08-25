import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';
import {KeycloakService} from 'keycloak-angular';

@Injectable()
export class TokenInterceptorInterceptor implements HttpInterceptor {

  constructor(private kcService: KeycloakService) {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    const authToken = this.kcService.getToken() || '';
    request = request.clone({
      setHeaders: {
        Authorization: 'Bearer ' + authToken
      }
    });
    return next.handle(request);  }
}
