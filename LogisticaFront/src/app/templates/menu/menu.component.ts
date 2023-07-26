import { Component, OnInit, OnChanges } from '@angular/core';
import { AuthService } from 'src/app/login/services/auth.service';
@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  login = false;

  constructor(public loginService:AuthService){ }


  ngOnInit():void {
    this.login = this.loginService.isUserLoggedIn();
  }
  ngOnChanges():void{
    this.login = this.loginService.isUserLoggedIn();
  }

}
