import { Component, HostBinding, Input, OnInit, OnChanges,ElementRef, ViewChild } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators, Form } from '@angular/forms';
import { Barco } from '../../domain/Barco';
import { BarcoService } from '../../services/barco.service';

@Component({
  selector: 'app-tabla-barco',
  templateUrl: './tabla-barco.component.html',
  styleUrls: ['./tabla-barco.component.css']
})
export class TablaBarcoComponent implements OnInit, OnChanges{
  @Input()
  cambio:  boolean= false;

  @ViewChild('pencil')
  pencil?: ElementRef;

  @ViewChild('tipoCuenta')
  tipoCuenta?: ElementRef[];

  isClicked: boolean = true;
  habilitoLapiz: boolean= true;

  barcos: Barco[] = [];
  barco?:Barco;

  constructor(private barcoService: BarcoService,fb: FormBuilder){}
  ngOnInit(): void{
    this.inicializoTabla();

  }

  ngOnChanges(){
    this.inicializoTabla();
  }

  public inicializoTabla():void{
    this.barcoService.selectBarco(new Barco()).subscribe(result =>{
      this.barcos = result;
    });
  }

  public habilitoCampos(id: any):void {
    const auxPencil = 'pencil_' + id;
    const nombreId  = 'nombreBarco_'+id;
    const nroFlotaId = 'nroFlota_'+id;

    this.isClicked = true;
    if(id != null){
      if(document.getElementById(nombreId)?.id === nombreId){
        document.getElementById(nombreId)?.removeAttribute('disabled');
        document.getElementById(nombreId)?.setAttribute('enabled', 'enabled');

        this.habilitoBotonGrabar(id);
        this.habilitoLapiz = false;
      }else{
        document.getElementById(nombreId)?.removeAttribute('enabled');
        document.getElementById(nombreId)?.setAttribute('disabled', 'disabled');

        this.desHabilitoBotonGrabar(id);
        this.habilitoLapiz = true;
      }

      if(document.getElementById(nroFlotaId)?.id === nroFlotaId){
        document.getElementById(nroFlotaId)?.removeAttribute('disabled');
        document.getElementById(nroFlotaId)?.setAttribute('enabled', 'enabled');

        this.habilitoBotonGrabar(id);
        this.habilitoLapiz = false;
      }else{
        document.getElementById(nroFlotaId)?.removeAttribute('enabled');
        document.getElementById(nroFlotaId)?.setAttribute('disabled', 'disabled');

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

  public actualizoBarco(item: any):void {
    const nroFlotaId = 'nroFlota_'+item.barcoId;
    const nombreBarcoId  = 'nombreBarco_'+item.barcoId;

    let barco = item;
    barco.barcoId = Number(item.barcoId);
    let valorNroFlota = (<HTMLInputElement>document.getElementById(nroFlotaId)).value;
    let valorNombreBarco = (<HTMLInputElement>document.getElementById(nombreBarcoId)).value;

    barco.nroFlota = valorNroFlota;
    barco.nombreBarco = valorNombreBarco;

    this.barcoService.updateBarco(barco).subscribe(result => {
      this.barco = result;
      this.habilitoLapiz = true;
      this.ngOnChanges();
    }, error => console.error('El error es: ' + JSON.stringify(error)));
  }

  public eliminoRegistro(id: any):void {
    console.log('ID: '+id);
    let barco = new Barco();
    barco.barcoId = id;
    this.barcoService.deleteBarco(barco).subscribe(result => {
      if (!this.habilitoLapiz) {
        this.habilitoLapiz = true;
      }
      this.ngOnChanges();
    }, error => console.error('El error es: ' + JSON.stringify(error)));
  }

}
