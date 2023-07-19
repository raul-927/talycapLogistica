import { Component, HostBinding, Input, OnInit, OnChanges,ElementRef, ViewChild } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators, Form } from '@angular/forms';
import { Camion } from '../../domain/Camion';
import { CamionService } from '../../services/camion.service';

@Component({
  selector: 'app-tabla-camion',
  templateUrl: './tabla-camion.component.html',
  styleUrls: ['./tabla-camion.component.css']
})
export class TablaCamionComponent  implements OnInit, OnChanges{
  @Input()
  cambio:  boolean= false;

  @ViewChild('pencil')
  pencil?: ElementRef;

  isClicked: boolean = true;
  habilitoLapiz: boolean= true;

  camiones: Camion[] = [];
  camion?:Camion;

  constructor(private camionService: CamionService,fb: FormBuilder){}
  ngOnInit(): void{
    this.inicializoTabla();

  }

  ngOnChanges(){
    this.inicializoTabla();
  }


  public inicializoTabla():void{
    this.camionService.selectCamion(new Camion()).subscribe(result =>{
      this.camiones = result;
    });
  }

  public habilitoCampos(id: any):void {
    const auxPencil = 'pencil_' + id;
    const placaId  = 'placa_'+id;
    const marcaId = 'marca_'+id;
    const modeloId = 'modelo_'+id;

    this.isClicked = true;
    if(id != null){
      if(document.getElementById(placaId)?.id === placaId){
        document.getElementById(placaId)?.removeAttribute('disabled');
        document.getElementById(placaId)?.setAttribute('enabled', 'enabled');

        document.getElementById(marcaId)?.removeAttribute('disabled');
        document.getElementById(marcaId)?.setAttribute('enabled', 'enabled');

        document.getElementById(modeloId)?.removeAttribute('disabled');
        document.getElementById(modeloId)?.setAttribute('enabled', 'enabled');

        this.habilitoBotonGrabar(id);
        this.habilitoLapiz = false;
      }else{
        document.getElementById(placaId)?.removeAttribute('enabled');
        document.getElementById(placaId)?.setAttribute('disabled', 'disabled');

        document.getElementById(marcaId)?.removeAttribute('enabled');
        document.getElementById(marcaId)?.setAttribute('disabled', 'disabled');

        document.getElementById(modeloId)?.removeAttribute('enabled');
        document.getElementById(modeloId)?.setAttribute('disabled', 'disabled');

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

  public actualizoCamion(item: any):void {
    const placaId = 'placa_'+item.camionId;
    const marcaId  = 'marca_'+item.camionId;
    const modeloId = 'modelo_'+item.camionId;

    let camion = item;
    camion.camionId = Number(item.camionId);
    let valorPlaca = (<HTMLInputElement>document.getElementById(placaId)).value;
    let valorMarca = (<HTMLInputElement>document.getElementById(marcaId)).value;
    let valorModelo = (<HTMLInputElement>document.getElementById(modeloId)).value;

    camion.placa = valorPlaca;
    camion.marca = valorMarca;
    camion.modelo = valorModelo;

    this.camionService.updateCamion(camion).subscribe(result => {
      this.camion = result;
      this.habilitoLapiz = true;
      this.ngOnChanges();
    }, error => console.error('El error es: ' + JSON.stringify(error)));
  }

  public eliminoRegistro(id: any):void {
    console.log('ID: '+id);
    let camion = new Camion();
    camion.camionId = id;
    this.camionService.deleteCamion(camion).subscribe(result => {
      if (!this.habilitoLapiz) {
        this.habilitoLapiz = true;
      }
      this.ngOnChanges();
    }, error => console.error('El error es: ' + JSON.stringify(error)));
  }
}
