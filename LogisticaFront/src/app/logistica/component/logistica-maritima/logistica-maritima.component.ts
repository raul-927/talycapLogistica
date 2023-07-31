import { NgForm } from '@angular/forms';
import { Component, EventEmitter, OnChanges, OnInit, Output } from '@angular/core';
import {FormsModule, FormBuilder, FormGroup, FormControl} from '@angular/forms';
import { LogisticaMaritima } from '../../domain/LogisticaMaritima';
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
  barcoList: Barco[] = [];
  puertoList: Puerto[]=[];
  opcion?:string;
  @Output() logisticaMaritimaFormGroupEmmiter = new EventEmitter<FormGroup> ;
  logisticaMaritimaFormGroup: FormGroup;
  barco:               FormControl = new FormControl();
  puerto:              FormControl = new FormControl();
  constructor(private formBuilder: FormBuilder,
    private puertoService: PuertoService,
    private barcoService: BarcoService){

    this.logisticaMaritimaFormGroup = formBuilder.group({
      barco:  new FormControl(),
      puerto: new FormControl()

    });
  }



  ngOnInit(): void {
    this.iniciarSelectorBarco();
    this.iniciarSelectorPuerto();
  }
  ngOnChanges():void{

  }
  enviarFormGroup(){
    this.logisticaMaritimaFormGroupEmmiter.emit(this.logisticaMaritimaFormGroup);
  }

  public iniciarSelectorBarco():void{
    this.barcoService.selectBarco(new Barco()).subscribe(result =>{
      this.barcoList = result;
    });
  }

  public iniciarSelectorPuerto():void{
    this.puertoService.selectPuerto(new Puerto).subscribe( result=>{
      this.puertoList = result;
    });
  }

}
