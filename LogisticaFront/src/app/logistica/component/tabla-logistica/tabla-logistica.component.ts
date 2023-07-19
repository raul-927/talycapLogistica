import { Component, HostBinding, Input, OnInit, OnChanges,ElementRef, ViewChild } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators, Form } from '@angular/forms';
import { Logistica } from '../../domain/Logistica';
import { LogisticaService } from '../../services/logistica.service';
import { TipoLogisticaEnum } from '../../enumerador/TipoLogisticaEnum';

@Component({
  selector: 'app-tabla-logistica',
  templateUrl: './tabla-logistica.component.html',
  styleUrls: ['./tabla-logistica.component.css']
})
export class TablaLogisticaComponent  implements OnInit, OnChanges{
  @Input()
  cambio:  boolean= false;

  @ViewChild('pencil')
  pencil?: ElementRef;

  isClicked: boolean = true;
  habilitoLapiz: boolean= true;

  logisticas: Logistica[] =[];
  logistica?: Logistica;

  optionsEnumUbicacion?: string[];

  constructor(private logisticaService: LogisticaService,fb: FormBuilder){}
  ngOnInit(): void{
    this.inicializoTabla();

  }

  ngOnChanges(){
    this.inicializoTabla();
  }

  public inicializoTabla():void{
    this.logisticaService.selectLogistica(new Logistica()).subscribe(result =>{
      this.logisticas = result;
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

  public inicioSelectTipoLogistica(): void{
    this.optionsEnumUbicacion = Object.keys(TipoLogisticaEnum);
  }

}
