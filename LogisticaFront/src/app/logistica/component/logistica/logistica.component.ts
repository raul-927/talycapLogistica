import { NgForm } from '@angular/forms';
import { Component, OnChanges, OnInit, Input } from '@angular/core';
import {FormsModule, FormBuilder, FormGroup, FormControl} from '@angular/forms';
import { Logistica } from '../../domain/Logistica';
import { LogisticaService } from '../../services/logistica.service';
import { TipoLogisticaEnum } from '../../enumerador/TipoLogisticaEnum';
import { TipoProducto } from 'src/app/tipoproducto/domain/TipoProducto';
import { TipoProductoService } from 'src/app/tipoproducto/services/tipo-producto.service';
import { ClienteServiceService } from 'src/app/clientes/services/cliente-service.service';
import { Cliente } from 'src/app/clientes/domain/Cliente';
import { LogisticaMaritimaComponent } from '../logistica-maritima/logistica-maritima.component';
import { LogisticaTerrestreComponent } from '../logistica-terrestre/logistica-terrestre.component';
import { Router } from '@angular/router';
import { LogisticaMaritima } from '../../domain/LogisticaMaritima';
import { LogisticaTerrestre } from '../../domain/LogisticaTerrestre';
import { Barco } from 'src/app/barco/domain/Barco';
import { Puerto } from 'src/app/puerto/domain/Puerto';
import { Camion } from 'src/app/camion/domain/Camion';
import { Bodega } from 'src/app/bodega/domain/Bodega';

@Component({
  selector: 'app-logistica',
  templateUrl: './logistica.component.html',
  styleUrls: ['./logistica.component.css']
})
export class LogisticaComponent implements OnInit , OnChanges{

  cambio: boolean = false;
  logistica?:Logistica;
  defaultValue: string ='Seleccione una opción';
  defaultValue2: string ='Seleccione una opción';
  defaultValue3: string ='Seleccione una opción';
  optionsEnumTipoLogistica?: string[];
  tipProductoList: TipoProducto[] = [];
  clientes: Cliente[] = [];
  opcion?:string;

  logisticaMaritima?: LogisticaMaritima;
  logisticaTerrestre?: LogisticaTerrestre;

  barco: Barco = new Barco();
  puerto: Puerto = new Puerto();

  camion: Camion = new Camion();
  bodega: Bodega = new Bodega();

   logisticaFormGroup:  FormGroup;
   @Input() logisticaMaritimaFormGroup?: FormGroup;
   @Input() logisticaTerrestreFormGroup?: FormGroup;

  fechaEntrega:        FormControl = new FormControl();
  tipoProducto:        FormControl = new FormControl();
  precioEnvio:         FormControl = new FormControl();
  cantidadProducto:    FormControl = new FormControl();
  subTotal:            FormControl = new FormControl();
  porcentajeDescuento: FormControl = new FormControl();
  total:               FormControl = new FormControl();
  cliente:             FormControl = new FormControl();
  tipoLogistica:       FormControl = new FormControl();

  constructor(private router: Router,
    private formBuilder: FormBuilder,
    private logisticaService: LogisticaService,
    private tipoProductoService: TipoProductoService,
    private clienteService: ClienteServiceService){

    this.logisticaFormGroup = formBuilder.group({
      fechaEntrega:        new FormControl(),
      tipoProducto:        new FormControl(),
      precioEnvio:         new FormControl(),
      cantidadProducto:    new FormControl(),
      subTotal:            new FormControl(),
      porcentajeDescuento: new FormControl(),
      total:               new FormControl(),
      cliente:             new FormControl(),
      tipoLogistica:       new FormControl()

    });
  }



  ngOnInit(): void {
    if(!sessionStorage.getItem('token')){
      this.router.navigate(['/']);
    }else{
      this.inicioSelectTipoLogistica();
      this.iniciarSelectorTipoProducto();
      this.iniciarSelectorClientes();
    }

  }
  ngOnChanges():void{

  }

  public getLogisticaMaritima(e:any){
    this.puerto.puertoId = e.get('puerto').value;
    this.barco.barcoId = e.get('barco').value;
    this.logisticaMaritima = new LogisticaMaritima();
    this.logisticaMaritima.barco = this.barco;
    this.logisticaMaritima.puerto = this.puerto;
  }

  public getLogisticaTerrestre(e:any){
    this.bodega.bodegaId = e.get('bodega').value;
    this.camion.camionId = e.get('camion').value;

    this.logisticaTerrestre = new LogisticaTerrestre();
    this.logisticaTerrestre.camion = this.camion;
    this.logisticaTerrestre.bodega = this.bodega;
  }

  public modelChangeFn(abc: string) {
    this.opcion = abc;
  }

  public insertLogistica(param: any):void{

    let logistica: Logistica = new Logistica();
    logistica!.fechaEntrega = param.fechaEntrega;
    logistica!.tipoProducto!.tipoProductoId = param.tipoProducto;
    logistica.precioEnvio = param.precioEnvio;
    logistica.cantidadProducto = param.cantidadProducto;
    logistica!.cliente!.clienteId = param.cliente;
    if(this.logisticaMaritima!== undefined){
      logistica.logisticaMaritima = this.logisticaMaritima;
      logistica.logisticaTerrestre = undefined;
    }
    else if(this.logisticaTerrestre!== undefined){
      logistica.logisticaTerrestre = this.logisticaTerrestre;
      logistica.logisticaMaritima = undefined;
    }

    this.logisticaService.insertLogistica(logistica).subscribe(result =>{
      this.cambio = true;
      this.logistica = result;
    })
  }

  public inicioSelectTipoLogistica(): void{

    this.optionsEnumTipoLogistica = Object.keys(TipoLogisticaEnum);
  }

  public iniciarSelectorTipoProducto():void{
    this.tipoProductoService.selectTipoProducto(new TipoProducto()).subscribe(result =>{
      this.tipProductoList = result;
    });
  }

  public iniciarSelectorClientes():void{
    this.clienteService.selectCliente(new Cliente()).subscribe(cli =>{
      this.clientes = cli;
    });
  }

}
