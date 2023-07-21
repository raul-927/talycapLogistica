import { Component, ChangeDetectorRef, ComponentFactoryResolver,OnInit, AfterViewInit } from '@angular/core';

@Component({
  selector: 'app-body',
  templateUrl: './body.component.html',
  styleUrls: ['./body.component.css']
})
export class BodyComponent implements OnInit , AfterViewInit{

  loading = true;

  constructor(private cd: ChangeDetectorRef, private componentFactoryResolver: ComponentFactoryResolver) {

  }


  ngOnInit(): void {
    this.loading = false;
  }

  ngAfterViewInit(){

    this.loading = true;
    this.cd.detectChanges();

    /*ListaComponentes.LISTA_COMPONENTES.forEach( resultado =>{
      this.createComponent(resultado.selector);
    });*/
  }

}
