import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ClientesComponent } from './clientes/components/clientes.component';
import { BodyComponent } from './templates/body/body.component';
import { MenuComponent } from './templates/menu/menu.component';
import { FooterComponent } from './templates/footer/footer.component';
import { ColumnLeftComponent } from './templates/column-left/column-left.component';
import { ColumnRightComponent } from './templates/column-right/column-right.component';
import { TablaClientesComponent } from './clientes/components/tabla-clientes/tabla-clientes.component';
import { BarcoComponent } from './barco/components/barco/barco.component';
import { BodegaComponent } from './bodega/components/bodega/bodega.component';
import { CamionComponent } from './camion/components/camion/camion.component';
import { TablaBodegaComponent } from './bodega/components/tabla-bodega/tabla-bodega.component';
import { TablaCamionComponent } from './camion/components/tabla-camion/tabla-camion.component';
import { TablaBarcoComponent } from './barco/components/tabla-barco/tabla-barco.component';
import { TipoProductoComponent } from './tipoproducto/components/tipo-producto/tipo-producto.component';
import { TablaTipoProductoComponent } from './tipoproducto/components/tabla-tipo-producto/tabla-tipo-producto.component';
import { PuertoComponent } from './puerto/components/puerto/puerto.component';
import { TablaPuertoComponent } from './puerto/components/tabla-puerto/tabla-puerto.component';
import { LogisticaComponent } from './logistica/component/logistica/logistica.component';
import { TablaLogisticaComponent } from './logistica/component/tabla-logistica/tabla-logistica.component';
import { LoginComponent } from './login/components/login/login.component';

const ENTRYCOMPONENTS = [
  BarcoComponent,
  BodegaComponent,
  ClientesComponent
];

@NgModule({
  declarations: [
    AppComponent,
    ClientesComponent,
    BodyComponent,
    MenuComponent,
    FooterComponent,
    ColumnLeftComponent,
    ColumnRightComponent,
    TablaClientesComponent,
    BarcoComponent,
    BodegaComponent,
    CamionComponent,
    TablaBodegaComponent,
    TablaCamionComponent,
    TablaBarcoComponent,
    TipoProductoComponent,
    TablaTipoProductoComponent,
    PuertoComponent,
    TablaPuertoComponent,
    LogisticaComponent,
    TablaLogisticaComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],

  bootstrap: [AppComponent, ENTRYCOMPONENTS],

})
export class AppModule { }
