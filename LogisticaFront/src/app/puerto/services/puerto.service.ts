import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Url } from 'src/app/constantes/Url';
import { Puerto } from '../domain/Puerto';
import { HeadersService } from 'src/app/utils/HeadersService';
import { Credentials } from 'src/app/login/domain/Credentials';
@Injectable({
  providedIn: 'root'
})
export class PuertoService {

  constructor(private http: HttpClient) { }

  public insertPuerto(puerto: Puerto): Observable<Puerto>{
    return this.http.post<Puerto>(Url.URL_BASE+'/puertos', puerto, {headers: HeadersService.headers()});
  }

  public updatePuerto(puerto: Puerto): Observable<Puerto>{
    return this.http.put<Puerto>(Url.URL_BASE+'/puertos', puerto, {headers: HeadersService.headers()});
  }

  public selectPuerto(puerto: Puerto): Observable<Puerto[]>{
    return this.http.post<Puerto[]>(Url.URL_BASE+'/puertos/select', puerto, {headers: HeadersService.headers()});
  }

  public deletePuerto(puerto: Puerto): Observable<any>{

    return this.http.delete<Puerto>(Url.URL_BASE+'/puertos', {headers: this.headers().append('body',puerto.puertoId!.toString())});
  }

  private headers(){
    let headers: HttpHeaders = new HttpHeaders();
    let token = sessionStorage.getItem('token');
    let credentials: Credentials = new Credentials();
    credentials = JSON.parse(sessionStorage.getItem('currentUser')!);
    if(sessionStorage.getItem('currentUser')){
      token = credentials.token_type+' '+credentials.access_token;
    }
    headers = headers.append('Content-Type', 'application/json');
    headers = headers.append('Authorization',token!);

    return headers;
  }
}
