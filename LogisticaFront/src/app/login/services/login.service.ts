import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
//import {Host} from '../constant/url/Host';
//import {LoginUrl} from '../constant/url/LoginUrl';
import { Token } from '@angular/compiler';
import { User } from '../domain/User';
import { map } from "rxjs/operators";
@Injectable({
  providedIn: 'root'
})
export class LoginService {
  //private static URL = Host.LOCAL_HOST + LoginUrl.LOGUIN_URL;

  public clientId = 'newClient';
  public redirectUri = 'http://localhost:8089/';

  constructor(private http: HttpClient) {
  }

  public login(user:User): Observable<string>{
    let headers: HttpHeaders = new HttpHeaders();
    headers.set('Content-Type', 'application/json');
    headers.set('Authorization', 'Basic Y291bnRlcjpzY2FydmFyZXo=');
    const usuario = this.http.post<string>('http://localhost:9091/oauth/token?grant_type=password&username=raul&password=12345', null);
    return usuario;
  }

  authenticate(username: string, password: any) {
    let headers: HttpHeaders = new HttpHeaders();
    headers = headers.set('Content-Type', 'application/json');
    headers = headers.set('Authorization', 'Basic Y2xpZW50OnNlY3JldA==');
    return this.http
      .post<any>("http://localhost:9091/oauth/token?grant_type=password&username=raul&password=12345", null, {headers: headers})
      .pipe(
        map(userData => {
          sessionStorage.setItem("username", username);
          let tokenStr = "Bearer " + userData.access_token;
          sessionStorage.setItem("token", tokenStr);
          return userData;
        })
      );
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem("username");
    console.log(!(user === null));
    return !(user === null);
  }

  logOut() {
    sessionStorage.removeItem("username");
    sessionStorage.removeItem("token");
  }

}
