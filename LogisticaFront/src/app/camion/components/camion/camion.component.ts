import { NgForm } from '@angular/forms';
import { Component, OnChanges, OnInit } from '@angular/core';
import {FormsModule, FormBuilder, FormGroup, FormControl} from '@angular/forms';
import { Camion } from '../../domain/Camion';
import { CamionService } from '../../services/camion.service';
import { AuthService } from 'src/app/login/services/auth.service';

@Component({
  selector: 'app-camion',
  templateUrl: './camion.component.html',
  styleUrls: ['./camion.component.css']
})
export class CamionComponent {

  cambio: boolean = false;
  camion: Camion = new Camion();
  camionFormGroup: FormGroup;
  placa: FormControl         = new FormControl();
  marca: FormControl         = new FormControl();
  modelo: FormControl         = new FormControl();

  constructor(private formBuilder: FormBuilder,private camionService: CamionService, private authService: AuthService){
    this.camionFormGroup = formBuilder.group({
      placa:    new FormControl(),
      marca:   new FormControl(),
      modelo:   new FormControl()
    });
  }

  public insertCamion(param: any):void{
    this.camionService.insertCamion(param).subscribe(result =>{
      this.cambio = true;
      this.camion = result;
    })
  }

}
