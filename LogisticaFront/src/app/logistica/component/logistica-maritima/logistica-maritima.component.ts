import { NgForm } from '@angular/forms';
import { Component, OnChanges, OnInit } from '@angular/core';
import {FormsModule, FormBuilder, FormGroup, FormControl} from '@angular/forms';
import { LogisticaMaritima } from '../../domain/LogisticaMaritima';
import { TipoLogisticaEnum } from '../../enumerador/TipoLogisticaEnum';
import { Barco } from 'src/app/barco/domain/Barco';
import { BarcoService } from 'src/app/barco/services/barco.service';
import { Puerto } from 'src/app/puerto/domain/Puerto';
import { PuertoService } from 'src/app/puerto/services/puerto.service';

@Component({
  selector: 'app-logistica-maritima',
  templateUrl: './logistica-maritima.component.html',
  styleUrls: ['./logistica-maritima.component.css']
})
export class LogisticaMaritimaComponent  implements OnInit , OnChanges{

  cambio: boolean = false;
  logisticaMaritima?:LogisticaMaritima;
  defaultValue: string ='Seleccione una opción';
  defaultValue2: string ='Seleccione una opción';
  optionsEnumTipoLogistica?: string[];
  barcoList: Barco[] = [];
  puertoList: Puerto[]=[];
  opcion?:string;
  logisticaMaritimaFormGroup:  FormGroup;
  tipoProducto:        FormControl = new FormControl();
  precioEnvio:         FormControl = new FormControl();
  cantidadProducto:    FormControl = new FormControl();
  subTotal:            FormControl = new FormControl();
  porcentajeDescuento: FormControl = new FormControl();
  total:               FormControl = new FormControl();
  fechaEntrega:        FormControl = new FormControl();
  cliente:             FormControl = new FormControl();
  tipoLogistica:       FormControl = new FormControl();

  constructor(private formBuilder: FormBuilder,
    private puertoService: PuertoService,
    private BarcoService: BarcoService){

    this.logisticaMaritimaFormGroup = formBuilder.group({
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
    this.iniciarSelectorBarco();
    this.iniciarSelectorPuerto();
  }
  ngOnChanges():void{

  }

  public insertLogisticaMaritima(param:any){

  }

  public inicioSelectTipoLogistica(): void{

    this.optionsEnumTipoLogistica = Object.keys(TipoLogisticaEnum);
    console.log('ENUM: '+this.defaultValue);
  }

  public iniciarSelectorBarco():void{
    this.BarcoService.selectBarco(new Barco()).subscribe(result =>{
      this.barcoList = result;
    });
  }

  public iniciarSelectorPuerto():void{
    this.puertoService.selectPuerto(new Puerto).subscribe( result=>{
      this.puertoList = result;
      console.log('PUERO: '+JSON.stringify(result));
    });
  }

}
