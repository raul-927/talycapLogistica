import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Url } from 'src/app/constantes/Url';
import { Cliente } from '../domain/Cliente';
import { Credentials } from 'src/app/login/domain/Credentials';

@Injectable({
  providedIn: 'root'
})
export class ClienteServiceService {

  constructor(private http: HttpClient) { }

  public insertCliente(cliente:Cliente): Observable<Cliente>{

    return this.http.post<Cliente>(Url.URL_BASE+'/clientes', cliente, {headers: this.headers()});
  }

  public updateCliente(cliente: Cliente): Observable<Cliente>{
    return this.http.put<Cliente>(Url.URL_BASE+'/clientes', cliente, {headers: this.headers()});
  }

  public deleteCliente(cliente:Cliente): Observable<Cliente>{
    return this.http.delete<Cliente>(Url.URL_BASE+'/clientes', {headers: this.headers().append('body',cliente.clienteId!.toString())});
  }

  public selectCliente(cliente: Cliente): Observable<Cliente[]>{
    return this.http.post<Cliente[]>(Url.URL_BASE+'/clientes'+'/select', cliente, {headers: this.headers()});
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
