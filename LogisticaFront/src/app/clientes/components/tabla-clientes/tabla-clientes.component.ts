
import { Component, HostBinding, Input, OnInit, OnChanges,ElementRef, ViewChild } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators, Form } from '@angular/forms';
import { ClienteServiceService } from '../../services/cliente-service.service';
import { Cliente } from '../../domain/Cliente';
@Component({
  selector: 'app-tabla-clientes',
  templateUrl: './tabla-clientes.component.html',
  styleUrls: ['./tabla-clientes.component.css']
})
export class TablaClientesComponent implements OnInit, OnChanges{

  @Input()
  cambio:  boolean= false;

  @ViewChild('pencil')
  pencil?: ElementRef;

  isClicked: boolean = true;
  clientes: Cliente[] = [];
  cliente?: Cliente;
  habilitoLapiz: boolean= true;


  constructor(private clienteService: ClienteServiceService,fb: FormBuilder){}

  ngOnInit(): void{
    this.inicializoTabla();

  }

  ngOnChanges(){
    this.inicializoTabla();
  }

  public inicializoTabla():void{
    this.clienteService.selectCliente(new Cliente()).subscribe( data => {
      this.clientes = data;
    });
  }

  public habilitoCampos(id: any):void {
    const auxPencil = 'pencil_' + id;
    const nombreId  = 'nombre_'+id;
    const apellidoId  = 'apellido_'+id;
    const documentoId    = 'documento_'+id;

    this.isClicked = true;
    if(id != null){
      if(document.getElementById(nombreId)?.id === nombreId){
        document.getElementById(nombreId)?.removeAttribute('disabled');
        document.getElementById(nombreId)?.setAttribute('enabled', 'enabled');

        document.getElementById(apellidoId)?.removeAttribute('disabled');
        document.getElementById(apellidoId)?.setAttribute('enabled', 'enabled');

        document.getElementById(documentoId)?.removeAttribute('disabled');
        document.getElementById(documentoId)?.setAttribute('enabled', 'enabled');

        this.habilitoBotonGrabar(id);
        this.habilitoLapiz = false;
      }else{
        document.getElementById(nombreId)?.removeAttribute('enabled');
        document.getElementById(nombreId)?.setAttribute('disabled', 'disabled');


        document.getElementById(apellidoId)?.removeAttribute('enabled');
        document.getElementById(apellidoId)?.setAttribute('disabled', 'disabled');

        document.getElementById(documentoId)?.removeAttribute('enabled');
        document.getElementById(documentoId)?.setAttribute('disabled', 'disabled');

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



  public actualizoCliente(item: any):void {
    const nombreId  = 'nombre_'+item.clienteId;
    const apellidoId  = 'apellido_'+item.clienteId;
    const documentoId    = 'documento_'+item.clienteId;
    console.log('nombreId: '+nombreId);
    console.log('apellidoId: '+apellidoId);
    console.log('documentoId: '+documentoId);
    let cliente = item;
    cliente.clienteId = Number(item.clienteId);
    console.log('NOMBRE: '+item.nombre);
    let valorNombre = (<HTMLInputElement>document.getElementById(nombreId)).value;
    let valorApellido = (<HTMLInputElement>document.getElementById(apellidoId)).value;
    let valorDocumento   = (<HTMLInputElement>document.getElementById(documentoId)).value;


    cliente.nombre = valorNombre;
    cliente.apellido = valorApellido;
    cliente.documento = valorDocumento;

    this.clienteService.updateCliente(cliente).subscribe(result => {
      this.cliente = result;
      this.habilitoLapiz = true;
      this.ngOnChanges();
    }, error => console.error('El error es: ' + JSON.stringify(error)));
  }

  public eliminoRegistro(id: any):void {
    console.log('ID: '+id);
    let cliente = new Cliente();
    cliente.clienteId = id;
    this.clienteService.deleteCliente(cliente).subscribe(result => {
      if (!this.habilitoLapiz) {
        this.habilitoLapiz = true;
      }
      this.ngOnChanges();
    }, error => console.error('El error es: ' + JSON.stringify(error)));
  }
}

