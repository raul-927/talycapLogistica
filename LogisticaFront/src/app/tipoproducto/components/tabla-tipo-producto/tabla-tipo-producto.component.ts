import { Component, HostBinding, Input, OnInit, OnChanges,ElementRef, ViewChild } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators, Form } from '@angular/forms';
import { TipoProducto } from '../../domain/TipoProducto';
import { TipoProductoService } from '../../services/tipo-producto.service';

@Component({
  selector: 'app-tabla-tipo-producto',
  templateUrl: './tabla-tipo-producto.component.html',
  styleUrls: ['./tabla-tipo-producto.component.css']
})
export class TablaTipoProductoComponent {


  @Input()
  cambio:  boolean= false;

  @ViewChild('pencil')
  pencil?: ElementRef;

  isClicked: boolean = true;
  habilitoLapiz: boolean= true;

  tipoProductos: TipoProducto[] = [];
  tipoProducto?:TipoProducto;

  constructor(private tipoProductoService: TipoProductoService,fb: FormBuilder){}
  ngOnInit(): void{
    this.inicializoTabla();

  }

  ngOnChanges(){
    this.inicializoTabla();
  }

  public inicializoTabla():void{
    this.tipoProductoService.selectTipoProducto(new TipoProducto()).subscribe(result =>{
      this.tipoProductos = result;
    });
  }

  public habilitoCampos(id: any):void {
    const auxPencil = 'pencil_' + id;
    const nombreTipoProductoId  = 'nombreTipoProducto_'+id;

    this.isClicked = true;
    if(id != null){
      if(document.getElementById(nombreTipoProductoId)?.id === nombreTipoProductoId){
        document.getElementById(nombreTipoProductoId)?.removeAttribute('disabled');
        document.getElementById(nombreTipoProductoId)?.setAttribute('enabled', 'enabled');

        this.habilitoBotonGrabar(id);
        this.habilitoLapiz = false;
      }else{
        document.getElementById(nombreTipoProductoId)?.removeAttribute('enabled');
        document.getElementById(nombreTipoProductoId)?.setAttribute('disabled', 'disabled');

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

  public actualizoTipoProducto(item: any):void {
    const nombreTipoProductoId = 'nombreTipoProducto_'+item.tipoProductoId;

    let tipoProducto = item;
    tipoProducto.tipoProductoId = Number(item.tipoProductoId);
    let valorNombreTipoProducto = (<HTMLInputElement>document.getElementById(nombreTipoProductoId)).value;

    tipoProducto.nombreTipoProducto = valorNombreTipoProducto;


    this.tipoProductoService.updateTipoProducto(tipoProducto).subscribe(result => {
      this.tipoProducto = result;
      this.habilitoLapiz = true;
      this.ngOnChanges();
    }, error => console.error('El error es: ' + JSON.stringify(error)));
  }

  public eliminoRegistro(id: any):void {
    console.log('ID: '+id);
    let tipoProducto = new TipoProducto();
    tipoProducto.tipoProductoId = id;
    this.tipoProductoService.deleteTipoProducto(tipoProducto).subscribe(result => {
      if (!this.habilitoLapiz) {
        this.habilitoLapiz = true;
      }
      this.ngOnChanges();
    }, error => console.error('El error es: ' + JSON.stringify(error)));
  }
}
