import { Component, ChangeDetectorRef, ComponentFactoryResolver,OnInit, AfterViewInit, OnChanges, Input, ViewChild } from '@angular/core';
import { LoginComponent } from 'src/app/login/components/login/login.component';
import { AuthService } from 'src/app/login/services/auth.service';

@Component({
  selector: 'app-container',
  templateUrl: './container.component.html',
  styleUrls: ['./container.component.css']
})
export class ContainerComponent implements OnInit , AfterViewInit {

  loading = true;
  login: boolean = false;
  @ViewChild(LoginComponent) loginComponent?:LoginComponent;

  constructor(public authService: AuthService, private cd: ChangeDetectorRef, private componentFactoryResolver: ComponentFactoryResolver) {

  }


  ngOnInit(): void {
    if(this.loginComponent?.loged){
      this.login = true;
    }
    else{
      this.login = false;
    }
    console.log('this.login: '+this.login);
    this.loading = false;
    this.authService.isUserLoggedIn();
    console.log('this.authService.isUserLoggedIn(): '+this.authService.isUserLoggedIn());
  }

  ngOnChanges():void{
    if(this.loginComponent?.loged){
      this.login = true;
    }
    else{
      this.login = false;
    }
    console.log('this.login: '+this.login);
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
