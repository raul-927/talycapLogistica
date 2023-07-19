import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Url } from 'src/app/constantes/Url';
import { Barco } from '../domain/Barco';
import { Credentials } from 'src/app/login/domain/Credentials';
import { HeadersService } from 'src/app/utils/HeadersService';
@Injectable({
  providedIn: 'root'
})
export class BarcoService {

  constructor(private http: HttpClient) { }

  public insertBarco(barco:Barco): Observable<Barco>{
    return this.http.post<Barco>(Url.URL_BASE+'/barcos', barco, {headers: this.headers()});
  }

  public updateBarco(barco:Barco): Observable<Barco>{
    return this.http.put<Barco>(Url.URL_BASE+'/barcos', barco, {headers: this.headers()});
  }

  public selectBarco(barco:Barco): Observable<Barco[]>{
    return this.http.post<Barco[]>(Url.URL_BASE+'/barcos/select', barco, {headers: HeadersService.headers()});
  }

  public deleteBarco(barco:Barco): Observable<any>{

    return this.http.delete<Barco>(Url.URL_BASE+'/barcos', {headers: this.headers().append('body',barco.barcoId!.toString())});
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
