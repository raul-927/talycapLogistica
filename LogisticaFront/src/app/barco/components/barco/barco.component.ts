import { NgForm } from '@angular/forms';
import { Component, OnChanges, OnInit } from '@angular/core';
import {FormsModule, FormBuilder, FormGroup, FormControl} from '@angular/forms';
import { BarcoService} from '../../services/barco.service';
import { Barco } from '../../domain/Barco';
import { AuthService } from 'src/app/login/services/auth.service';
@Component({
  selector: 'app-barco',
  templateUrl: './barco.component.html',
  styleUrls: ['./barco.component.css']
})
export class BarcoComponent implements OnInit , OnChanges{
  cambio: boolean = false;
  barco: Barco = new Barco();
  barcoFormGroup: FormGroup;
  nroFlota: FormControl         = new FormControl();
  nombreBarco: FormControl         = new FormControl();

  constructor(private formBuilder: FormBuilder,private barcoService: BarcoService, private authService: AuthService){
    this.barcoFormGroup = formBuilder.group({
      nroFlota:    new FormControl(),
      nombreBarco:   new FormControl()
    });
  }

  ngOnInit(): void {

  }
  ngOnChanges():void{

  }

  public insertBarco(param: any):void{
    this.barcoService.insertBarco(param).subscribe(result =>{
      this.cambio = true;
      this.barco = result;
    })
  }

}
