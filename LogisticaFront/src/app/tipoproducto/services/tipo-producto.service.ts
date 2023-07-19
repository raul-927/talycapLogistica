import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Url } from 'src/app/constantes/Url';
import { TipoProducto } from '../domain/TipoProducto';
import { HeadersService } from 'src/app/utils/HeadersService';
import { Credentials } from 'src/app/login/domain/Credentials';
@Injectable({
  providedIn: 'root'
})
export class TipoProductoService {

  constructor(private http: HttpClient) { }

  public insertTipoProducto(tipoProducto:TipoProducto): Observable<TipoProducto>{
    return this.http.post<TipoProducto>(Url.URL_BASE+'/tiposProductos', tipoProducto, {headers: HeadersService.headers()});
  }

  public updateTipoProducto(tipoProducto:TipoProducto): Observable<TipoProducto>{
    return this.http.put<TipoProducto>(Url.URL_BASE+'/tiposProductos', tipoProducto, {headers: HeadersService.headers()});
  }

  public selectTipoProducto(tipoProducto:TipoProducto): Observable<TipoProducto[]>{
    return this.http.post<TipoProducto[]>(Url.URL_BASE+'/tiposProductos/select', tipoProducto, {headers: HeadersService.headers()});
  }

  public deleteTipoProducto(tipoProducto:TipoProducto): Observable<any>{

    return this.http.delete<TipoProducto>(Url.URL_BASE+'/tiposProductos', {headers: this.headers().append('body',tipoProducto.tipoProductoId!.toString())});
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
