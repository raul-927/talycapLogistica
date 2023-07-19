import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClientesComponent } from './clientes/components/clientes.component';
import { BarcoComponent } from './barco/components/barco/barco.component';
import { LoginComponent } from './login/components/login/login.component';
import { AuthGuardService } from './login/services/auth-guard.service';
import { BodegaComponent } from './bodega/components/bodega/bodega.component';
import { CamionComponent } from './camion/components/camion/camion.component';
import { PuertoComponent } from './puerto/components/puerto/puerto.component';
import { LogisticaComponent } from './logistica/component/logistica/logistica.component';
import { TipoProductoComponent } from './tipoproducto/components/tipo-producto/tipo-producto.component';
const routes: Routes = [
  { path: 'login', component: LoginComponent ,canActivate: [AuthGuardService]},
  {path: 'clientes', component: ClientesComponent, canActivate: [AuthGuardService]},
  {path: 'barcos', component: BarcoComponent, canActivate: [AuthGuardService]},
  {path: 'bodegas', component: BodegaComponent, canActivate: [AuthGuardService]},
  {path: 'puertos', component: PuertoComponent, canActivate: [AuthGuardService]},
  {path: 'camiones', component: CamionComponent, canActivate: [AuthGuardService]},
  {path: 'logistica',component: LogisticaComponent, canActivate:[AuthGuardService]},
  {path: 'tipoproducto',component: TipoProductoComponent, canActivate: [AuthGuardService]},
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  // otherwise redirect to home
  { path: '**', redirectTo: '/login' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
