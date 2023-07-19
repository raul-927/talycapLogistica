import { Component, HostBinding, Input, OnInit, OnChanges,ElementRef, ViewChild } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators, Form } from '@angular/forms';
import { Puerto } from '../../domain/Puerto';
import { PuertoService } from '../../services/puerto.service';
import { UbicacionEnum } from '../../enumerador/UbicacionEnum';

@Component({
  selector: 'app-tabla-puerto',
  templateUrl: './tabla-puerto.component.html',
  styleUrls: ['./tabla-puerto.component.css']
})
export class TablaPuertoComponent  implements OnInit, OnChanges{
  @Input()
  cambio:  boolean= false;

  @ViewChild('pencil')
  pencil?: ElementRef;

  isClicked: boolean = true;
  habilitoLapiz: boolean= true;

  puertos: Puerto[] =[];
  puerto?: Puerto;

  optionsEnumUbicacion?: string[];

  constructor(private puertoService: PuertoService,fb: FormBuilder){}
  ngOnInit(): void{
    this.inicializoTabla();

  }

  ngOnChanges(){
    this.inicializoTabla();
  }

  public inicializoTabla():void{
    this.puertoService.selectPuerto(new Puerto()).subscribe(result =>{
      this.puertos = result;
    });
  }


  public habilitoCampos(id: any):void {
    const auxPencil = 'pencil_' + id;
    const descripcionId  = 'descripcion_'+id;
    const ubicacionId = 'ubicacion_'+id;
    this.isClicked = true;
    if(id != null){
      if(document.getElementById(descripcionId)?.id === descripcionId){
        document.getElementById(descripcionId)?.removeAttribute('disabled');
        document.getElementById(descripcionId)?.setAttribute('enabled', 'enabled');

        document.getElementById(ubicacionId)?.removeAttribute('disabled');
        document.getElementById(ubicacionId)?.setAttribute('enabled', 'enabled');

        this.habilitoBotonGrabar(id);
        this.habilitoLapiz = false;
      }else{
        document.getElementById(descripcionId)?.removeAttribute('enabled');
        document.getElementById(descripcionId)?.setAttribute('disabled', 'disabled');

        document.getElementById(ubicacionId)?.removeAttribute('enabled');
        document.getElementById(ubicacionId)?.setAttribute('disabled', 'disabled');

        this.desHabilitoBotonGrabar(id);
        this.habilitoLapiz = true;
      }
    }
  }

  public habilitoBotonGrabar(id: any):void {
    const aux = 'floppy_' + id;
    if (document.getElementById(aux)?.id === aux) {
      document.getElementById(aux)?.removeAttribute('disabled');
      document.getElementById(aux)?.setAttribute('enabled', 'enabled');
      this.habilitoLapiz = false;
    }

  }

  public desHabilitoBotonGrabar(id: any):void {
    const aux = 'floppy_' + id;
    if (document.getElementById(aux)?.id === aux) {
      document.getElementById(aux)?.removeAttribute('enabled');
      document.getElementById(aux)?.setAttribute('disabled', 'disabled');
      this.habilitoLapiz = true;
    }
  }

  public inicioSelectUbicacion(): void{
    this.optionsEnumUbicacion = Object.keys(UbicacionEnum);
  }

  public actualizoPuerto(item: any):void {
    const descripcionId = 'descripcion_'+item.puertoId;
    const ubicacionId = 'ubicacion_'+item.puertoId;
    let puerto = item;
    puerto.puertoId = Number(item.puertoId);
    let valorDescripcion = (<HTMLInputElement>document.getElementById(descripcionId)).value;
    let valorUbicacion = (<HTMLInputElement>document.getElementById(ubicacionId)).value;

    puerto.descripcion = valorDescripcion;

    switch(valorUbicacion){
      case UbicacionEnum.INTERNACIONAL:{
        puerto.ubicacion = UbicacionEnum.INTERNACIONAL;
        break;
      }
      case UbicacionEnum.NACIONAL:{
        puerto.ubicacion = UbicacionEnum.NACIONAL;
        break;
      }
    }
    this.puertoService.updatePuerto(puerto).subscribe(result => {
      this.puerto = result;
      this.habilitoLapiz = true;
      this.ngOnChanges();
    }, error => console.error('El error es: ' + JSON.stringify(error)));
  }

  public eliminoRegistro(id: any):void {
    console.log('ID: '+id);
    let puerto = new Puerto();
    puerto.puertoId = id;
    this.puertoService.deletePuerto(puerto).subscribe(result => {
      if (!this.habilitoLapiz) {
        this.habilitoLapiz = true;
      }
      this.ngOnChanges();
    }, error => console.error('El error es: ' + JSON.stringify(error)));
  }
}
