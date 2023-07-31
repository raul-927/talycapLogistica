import { NgForm } from '@angular/forms';
import { Component, EventEmitter, OnChanges, OnInit, Output } from '@angular/core';
import {FormsModule, FormBuilder, FormGroup, FormControl} from '@angular/forms';
import { LogisticaTerrestre } from '../../domain/LogisticaTerrestre';
import { Camion } from 'src/app/camion/domain/Camion';
import { CamionService } from 'src/app/camion/services/camion.service';
import { Bodega } from 'src/app/bodega/domain/Bodega';
import { BodegaService } from 'src/app/bodega/services/bodega.service';

@Component({
  selector: 'app-logistica-terrestre',
  templateUrl: './logistica-terrestre.component.html',
  styleUrls: ['./logistica-terrestre.component.css']
})
export class LogisticaTerrestreComponent  implements OnInit , OnChanges{
  cambio: boolean = false;
  logisticaTerrestre?:LogisticaTerrestre;
  defaultValue: string ='Seleccione una opción';
  defaultValue2: string ='Seleccione una opción';
  camionList: Camion[] = [];
  bodegaList: Bodega[]=[];
  opcion?:string;
  @Output() logisticaTerrestreFormGroupEmmiter = new EventEmitter<FormGroup> ;

  logisticaTerrestreFormGroup: FormGroup;
  camion:               FormControl = new FormControl();
  bodega:              FormControl = new FormControl();
  constructor(private formBuilder: FormBuilder,
    private bodegaService: BodegaService,
    private camionService: CamionService){

    this.logisticaTerrestreFormGroup = formBuilder.group({
      camion:  new FormControl(),
      bodega: new FormControl()

    });
  }


  ngOnInit(): void {
    this.iniciarSelectorBarco();
    this.iniciarSelectorPuerto();
  }
  ngOnChanges():void{

  }
  enviarFormGroup(){
    this.logisticaTerrestreFormGroupEmmiter.emit(this.logisticaTerrestreFormGroup);
  }

  public iniciarSelectorBarco():void{
    this.camionService.selectCamion(new Camion()).subscribe(result =>{
      this.camionList = result;
    });
  }

  public iniciarSelectorPuerto():void{
    this.bodegaService.selectBodega(new Bodega()).subscribe( result=>{
      this.bodegaList = result;
    });
  }
}
