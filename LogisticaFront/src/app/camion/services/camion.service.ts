import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Url } from 'src/app/constantes/Url';
import { Camion } from '../domain/Camion';
import { HeadersService } from 'src/app/utils/HeadersService';
import { Credentials } from 'src/app/login/domain/Credentials';
@Injectable({
  providedIn: 'root'
})
export class CamionService {

  constructor(private http: HttpClient) { }

  public insertCamion(camion:Camion): Observable<Camion>{
    return this.http.post<Camion>(Url.URL_BASE+'/camiones', camion, {headers: HeadersService.headers()});
  }

  public updateCamion(camion:Camion): Observable<Camion>{
    return this.http.put<Camion>(Url.URL_BASE+'/camiones', camion, {headers: HeadersService.headers()});
  }

  public selectCamion(camion:Camion): Observable<Camion[]>{
    return this.http.post<Camion[]>(Url.URL_BASE+'/camiones/select', camion, {headers: HeadersService.headers()});
  }

  public deleteCamion(camion:Camion): Observable<any>{

    return this.http.delete<Camion>(Url.URL_BASE+'/camiones',{headers: this.headers().append('body',camion.camionId!.toString())});
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
