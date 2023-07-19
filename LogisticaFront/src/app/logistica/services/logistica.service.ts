import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Url } from 'src/app/constantes/Url';
import { Logistica } from '../domain/Logistica';
@Injectable({
  providedIn: 'root'
})
export class LogisticaService {

  constructor(private http: HttpClient) { }

  public insertLogistica(logistica: Logistica): Observable<Logistica>{
    return this.http.post<Logistica>(Url.URL_BASE+'/logisticas', logistica, {headers: this.headers()});
  }

  public updateLogistica(logistica: Logistica): Observable<Logistica>{
    return this.http.put<Logistica>(Url.URL_BASE+'/logisticas', logistica, {headers: this.headers()});
  }

  public selectLogistica(logistica: Logistica): Observable<Logistica>{
    return this.http.post<Logistica>(Url.URL_BASE+'/logisticas/select', logistica, {headers: this.headers()});
  }

  public deleteLogistica(logistica: Logistica): Observable<any>{

    return this.http.delete<Logistica>(Url.URL_BASE+'/logisticas', {headers: this.headers(), body: logistica});
  }

  private headers(){
    let header: HttpHeaders = new HttpHeaders();
    header = header.append('Content-Type', 'application/json');

    return header;
  }
}
