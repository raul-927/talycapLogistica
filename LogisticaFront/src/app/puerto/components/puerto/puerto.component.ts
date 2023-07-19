import { NgForm } from '@angular/forms';
import { Component, OnChanges, OnInit } from '@angular/core';
import {FormsModule, FormBuilder, FormGroup, FormControl} from '@angular/forms';
import { Puerto } from '../../domain/Puerto';
import { PuertoService } from '../../services/puerto.service';
import { UbicacionEnum } from '../../enumerador/UbicacionEnum';
@Component({
  selector: 'app-puerto',
  templateUrl: './puerto.component.html',
  styleUrls: ['./puerto.component.css']
})
export class PuertoComponent  implements OnInit , OnChanges{

  cambio: boolean = false;
  puerto?:Puerto;
  defaultValue: string ='Seleccione una opción';
  optionsEnumUbicacion?: string[];

  puertoFormGroup: FormGroup;
  descripcion: FormControl = new FormControl();
  ubicacion: FormControl = new FormControl();

  constructor(private formBuilder: FormBuilder,private puertoService: PuertoService){
    this.puertoFormGroup = formBuilder.group({
      descripcion:    new FormControl(),
      ubicacion:    new FormControl()
    });
  }





  ngOnInit(): void {
    this.inicioSelectUbicacion();
  }
  ngOnChanges():void{

  }

  public insertPuerto(param: any):void{
    console.log(JSON.stringify(param));
    this.puertoService.insertPuerto(param).subscribe(result =>{
      this.cambio = true;
      this.puerto = result;
    })
  }

  public inicioSelectUbicacion(): void{

    this.optionsEnumUbicacion = Object.keys(UbicacionEnum);
    console.log('ENUM: '+this.defaultValue);
  }
}
