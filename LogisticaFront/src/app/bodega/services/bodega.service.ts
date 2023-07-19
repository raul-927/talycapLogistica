import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Url } from 'src/app/constantes/Url';
import { Bodega } from '../domain/Bodega';
import { HeadersService } from 'src/app/utils/HeadersService';
import { Credentials } from 'src/app/login/domain/Credentials';
@Injectable({
  providedIn: 'root'
})
export class BodegaService {

  constructor(private http: HttpClient) { }

  public insertBodega(bodega:Bodega): Observable<Bodega>{
    return this.http.post<Bodega>(Url.URL_BASE+'/bodegas', bodega, {headers: HeadersService.headers()});
  }

  public updateBodega(bodega:Bodega): Observable<Bodega>{
    return this.http.put<Bodega>(Url.URL_BASE+'/bodegas', bodega, {headers: HeadersService.headers()});
  }

  public selectBodega(bodega:Bodega): Observable<Bodega[]>{
    return this.http.post<Bodega[]>(Url.URL_BASE+'/bodegas/select', bodega, {headers: HeadersService.headers()});
  }

  public deleteBodega(bodega:Bodega): Observable<any>{

    return this.http.delete<Bodega>(Url.URL_BASE+'/bodegas', {headers: this.headers().append('body',bodega.bodegaId!.toString())});
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
