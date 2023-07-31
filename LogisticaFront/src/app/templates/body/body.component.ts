import { Component, ChangeDetectorRef, ComponentFactoryResolver,OnInit, AfterViewInit, OnChanges } from '@angular/core';
import { AuthService } from 'src/app/login/services/auth.service';

@Component({
  selector: 'app-body',
  templateUrl: './body.component.html',
  styleUrls: ['./body.component.css']
})
export class BodyComponent implements OnInit , AfterViewInit{

  loading = true;
  login = false;

  constructor(private authService: AuthService, private cd: ChangeDetectorRef, private componentFactoryResolver: ComponentFactoryResolver) {

  }


  ngOnInit(): void {
    this.login = this.authService.isUserLoggedIn();
    this.loading = false;
    this.authService.isUserLoggedIn();
  }

  ngOnChanges():void{
    this.login = this.authService.isUserLoggedIn();
  }

  ngAfterViewInit(){
    this.login = this.authService.isUserLoggedIn();
    this.loading = true;
    this.cd.detectChanges();

    /*ListaComponentes.LISTA_COMPONENTES.forEach( resultado =>{
      this.createComponent(resultado.selector);
    });*/
  }

}
