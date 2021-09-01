import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthenticationService } from '../services/authentication.service';

@Injectable()
export class AuthenticationInterceptor implements HttpInterceptor {

  constructor(private _auth: AuthenticationService) {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    console.log("intercepted ! " + this._auth.connected);
    if (this._auth.connected) {
      request = request.clone({
        setHeaders: {
          Authorization: "Basic " + btoa(this._auth.utilisateur?.email + ":" + this._auth.utilisateur?.password)
        }
      });
    }
    return next.handle(request);
  }
}
