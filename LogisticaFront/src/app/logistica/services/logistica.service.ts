import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Url } from 'src/app/constantes/Url';
import { Logistica } from '../domain/Logistica';
import { HeadersService } from 'src/app/utils/HeadersService';
import { Credentials } from 'src/app/login/domain/Credentials';
@Injectable({
  providedIn: 'root'
})
export class LogisticaService {

  constructor(private http: HttpClient) { }

  public insertLogistica(logistica: Logistica): Observable<Logistica>{
    return this.http.post<Logistica>(Url.URL_BASE+'/logisticas', logistica, {headers: HeadersService.headers()});
  }

  public updateLogistica(logistica: Logistica): Observable<Logistica>{
    return this.http.put<Logistica>(Url.URL_BASE+'/logisticas', logistica, {headers: HeadersService.headers()});
  }

  public selectLogistica(logistica: Logistica): Observable<Logistica[]>{
    return this.http.post<Logistica[]>(Url.URL_BASE+'/logisticas/select', logistica, {headers: HeadersService.headers()});
  }

  public deleteLogistica(logistica: Logistica): Observable<any>{

    return this.http.delete<Logistica>(Url.URL_BASE+'/logisticas', {headers: this.headers().append('body',logistica.logisticaId!.toString())});
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
