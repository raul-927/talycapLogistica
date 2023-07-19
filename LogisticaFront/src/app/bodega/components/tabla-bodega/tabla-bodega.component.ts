import { Component, HostBinding, Input, OnInit, OnChanges,ElementRef, ViewChild } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators, Form } from '@angular/forms';
import { Bodega } from '../../domain/Bodega';
import { BodegaService } from '../../services/bodega.service';
@Component({
  selector: 'app-tabla-bodega',
  templateUrl: './tabla-bodega.component.html',
  styleUrls: ['./tabla-bodega.component.css']
})
export class TablaBodegaComponent implements OnInit, OnChanges{
  @Input()
  cambio:  boolean= false;

  @ViewChild('pencil')
  pencil?: ElementRef;

  isClicked: boolean = true;
  habilitoLapiz: boolean= true;

  bodegas: Bodega[] = [];
  bodega?:Bodega;


  constructor(private bodegaService: BodegaService,fb: FormBuilder){}
  ngOnInit(): void{
    this.inicializoTabla();

  }

  ngOnChanges(){
    this.inicializoTabla();
  }

  public inicializoTabla():void{
    this.bodegaService.selectBodega(new Bodega()).subscribe(result =>{
      this.bodegas = result;
    });
  }

  public habilitoCampos(id: any):void {
    const auxPencil = 'pencil_' + id;
    const nombreBodegaId  = 'nombreBodega_'+id;

    this.isClicked = true;
    if(id != null){
      if(document.getElementById(nombreBodegaId)?.id === nombreBodegaId){
        document.getElementById(nombreBodegaId)?.removeAttribute('disabled');
        document.getElementById(nombreBodegaId)?.setAttribute('enabled', 'enabled');

        this.habilitoBotonGrabar(id);
        this.habilitoLapiz = false;
      }else{
        document.getElementById(nombreBodegaId)?.removeAttribute('enabled');
        document.getElementById(nombreBodegaId)?.setAttribute('disabled', 'disabled');

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

  public actualizoBodega(item: any):void {
    const nombreBodegaId = 'nombreBodega_'+item.bodegaId;

    let bodega = item;
    bodega.bodegaId = Number(item.bodegaId);
    let valorNombreBodega = (<HTMLInputElement>document.getElementById(nombreBodegaId)).value;

    bodega.nombreBodega = valorNombreBodega;


    this.bodegaService.updateBodega(bodega).subscribe(result => {
      this.bodega = result;
      this.habilitoLapiz = true;
      this.ngOnChanges();
    }, error => console.error('El error es: ' + JSON.stringify(error)));
  }

  public eliminoRegistro(id: any):void {
    console.log('ID: '+id);
    let bodega = new Bodega();
    bodega.bodegaId = id;
    this.bodegaService.deleteBodega(bodega).subscribe(result => {
      if (!this.habilitoLapiz) {
        this.habilitoLapiz = true;
      }
      this.ngOnChanges();
    }, error => console.error('El error es: ' + JSON.stringify(error)));
  }
}
