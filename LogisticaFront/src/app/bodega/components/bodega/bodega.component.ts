import { NgForm } from '@angular/forms';
import { Component, OnChanges, OnInit } from '@angular/core';
import {FormsModule, FormBuilder, FormGroup, FormControl} from '@angular/forms';
import { Bodega } from '../../domain/Bodega';
import { BodegaService } from '../../services/bodega.service';

import { AuthService } from 'src/app/login/services/auth.service';

@Component({
  selector: 'app-bodega',
  templateUrl: './bodega.component.html',
  styleUrls: ['./bodega.component.css']
})
export class BodegaComponent implements OnInit , OnChanges{

  cambio: boolean = false;
  bodega: Bodega = new Bodega();
  bodegaFormGroup: FormGroup;
  nombreBodega: FormControl = new FormControl();

  constructor(private formBuilder: FormBuilder,private bodegaService: BodegaService, private authService: AuthService){
    this.bodegaFormGroup = formBuilder.group({
      nombreBodega:    new FormControl()
    });
  }

  ngOnInit(): void {

  }
  ngOnChanges():void{

  }
  public insertBodega(param: any):void{
    console.log(JSON.stringify(param));
    this.bodegaService.insertBodega(param).subscribe(result =>{
      this.cambio = true;
      this.bodega = result;
    })
  }

}
