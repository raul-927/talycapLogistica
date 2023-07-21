import { NgForm } from '@angular/forms';
import { Component, OnChanges, OnInit } from '@angular/core';
import {FormsModule, FormBuilder, FormGroup, FormControl} from '@angular/forms';
import { TipoProducto } from '../../domain/TipoProducto';
import { TipoProductoService } from '../../services/tipo-producto.service';
import { Router, ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-tipo-producto',
  templateUrl: './tipo-producto.component.html',
  styleUrls: ['./tipo-producto.component.css']
})
export class TipoProductoComponent implements OnInit{

  cambio: boolean = false;
  tipoProducto: TipoProducto = new TipoProducto();
  productoFormGroup: FormGroup;
  nombreTipoProducto: FormControl = new FormControl();

  constructor(private router: Router, private formBuilder: FormBuilder,private tipoProductoService: TipoProductoService){
    this.productoFormGroup = formBuilder.group({
      nombreTipoProducto:    new FormControl()
    });
  }
  ngOnInit(): void {
    if(!sessionStorage.getItem('token')){
      this.router.navigate(['/']);
    }
  }

  public insertTipoProducto(param: any):void{
    console.log(JSON.stringify(param));
    this.tipoProductoService.insertTipoProducto(param).subscribe(result =>{
      this.cambio = true;
      this.tipoProducto = result;
    })
  }

}
