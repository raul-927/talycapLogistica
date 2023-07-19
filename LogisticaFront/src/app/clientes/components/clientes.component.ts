import { NgForm } from '@angular/forms';
import { Component, OnChanges, OnInit } from '@angular/core';
import {FormsModule, FormBuilder, FormGroup, FormControl} from '@angular/forms';
import { ClienteServiceService } from 'src/app/clientes/services/cliente-service.service';
import { Cliente } from 'src/app/clientes/domain/Cliente';


@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.css']
})
export class ClientesComponent implements OnInit , OnChanges{
  defaultValue: string ='Seleccione una opción';
  defaultValue2: string ='Seleccione una opción';

  cambio: boolean = false;
  optionsEnumGenero?: string[];
  cliente: Cliente = new Cliente();
  clientes: Cliente[] = [];

  clienteFormGroup: FormGroup;
  nombre: FormControl         = new FormControl();
  apellido: FormControl         = new FormControl();
  documento: FormControl           = new FormControl();

  constructor(private formBuilder: FormBuilder, private clienteService: ClienteServiceService){
    this.clienteFormGroup = formBuilder.group({
      nombre:    new FormControl(),
      apellido:   new FormControl(),
      documento:       new FormControl(),
    });

  }

  ngOnInit(): void {
    this.iniciarSelectorClientes();
  }
  ngOnChanges():void{

  }
  public iniciarSelectorClientes():void{
    this.clienteService.selectCliente(new Cliente()).subscribe(result =>{
      this.clientes = result;
    });
  }

  public insertCliente(param: any): void{
    let cliente = new Cliente();
    cliente = param;
    this.clienteService.insertCliente(cliente).subscribe(result =>{
      this.cliente = result;
      this.cambio = true;

    });

    this.clienteService.selectCliente(new Cliente()).subscribe(result =>{
      this.clientes = result;
    })
  }
}
