import { NgForm } from '@angular/forms';
import { Component, OnChanges, OnInit } from '@angular/core';
import {FormsModule, FormBuilder, FormGroup, FormControl} from '@angular/forms';
import { Logistica } from '../../domain/Logistica';
import { LogisticaService } from '../../services/logistica.service';
import { TipoLogisticaEnum } from '../../enumerador/TipoLogisticaEnum';
import { TipoProducto } from 'src/app/tipoproducto/domain/TipoProducto';
import { TipoProductoService } from 'src/app/tipoproducto/services/tipo-producto.service';
import { Router } from '@angular/router';
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
  optionsEnumTipoLogistica?: string[];
  tipProductoList: TipoProducto[] = [];
  opcion?:string;
  logisticaFormGroup:  FormGroup;
  tipoProducto:        FormControl = new FormControl();
  precioEnvio:         FormControl = new FormControl();
  cantidadProducto:    FormControl = new FormControl();
  subTotal:            FormControl = new FormControl();
  porcentajeDescuento: FormControl = new FormControl();
  total:               FormControl = new FormControl();
  fechaEntrega:        FormControl = new FormControl();
  cliente:             FormControl = new FormControl();
  tipoLogistica:       FormControl = new FormControl();

  constructor(private router: Router,
    private formBuilder: FormBuilder,
    private logisticaService: LogisticaService,
    private tipoProductoService: TipoProductoService){

    this.logisticaFormGroup = formBuilder.group({
      tipoProducto:        new FormControl(),
      precioEnvio:         new FormControl(),
      cantidadProducto:    new FormControl(),
      subTotal:            new FormControl(),
      porcentajeDescuento: new FormControl(),
      total:               new FormControl(),
      fechaEntrega:        new FormControl(),
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
    }

  }
  ngOnChanges():void{

  }

  public modelChangeFn(abc: string) {
    this.opcion = abc;
  }

  public insertPuerto(param: any):void{
    console.log(JSON.stringify(param));
    this.logisticaService.insertLogistica(param).subscribe(result =>{
      this.cambio = true;
      this.logistica = result;
    })
  }

  public inicioSelectTipoLogistica(): void{

    this.optionsEnumTipoLogistica = Object.keys(TipoLogisticaEnum);
    console.log('ENUM: '+this.defaultValue);
  }

  public iniciarSelectorTipoProducto():void{
    this.tipoProductoService.selectTipoProducto(new TipoProducto()).subscribe(result =>{
      this.tipProductoList = result;
    });
  }

}
