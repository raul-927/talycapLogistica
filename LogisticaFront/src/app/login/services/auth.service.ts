import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private currentUserSubject: BehaviorSubject<Credential>;
  public currentUser: Observable<Credential>;


  constructor(private http: HttpClient) {
    this.currentUserSubject = new BehaviorSubject<Credential>(JSON.parse(sessionStorage.getItem('currentUser')||'{}'));
    this.currentUser = this.currentUserSubject.asObservable();
  }

  public get currentUserValue(): Credential {
    return this.currentUserSubject.value;
  }

  login(username: string, password: string) {
    let headers: HttpHeaders = new HttpHeaders();
    headers = headers.set('Content-Type', 'application/json');
    headers = headers.set('Authorization', 'Basic Y2xpZW50OnNlY3JldA==');
    return this.http.post<any>('http://localhost:9091/oauth/token?grant_type=password&username='+username+'&password='+password, { username, password }, {headers: headers})
        .pipe(map(user => {
            // store user details and basic auth credentials in local storage to keep user logged in between page refreshes
            user.authdata = window.btoa(username + ':' + password);
            sessionStorage.setItem('token', user.token_type+" "+user.access_token);
            sessionStorage.setItem('currentUser', JSON.stringify(user));
            this.currentUserSubject.next(user);
            return user;
        }));
  }

  logout() {
    // remove user from local storage to log user out
    sessionStorage.removeItem('currentUser');
    this.currentUserSubject.next(new Credential());
  }
}
