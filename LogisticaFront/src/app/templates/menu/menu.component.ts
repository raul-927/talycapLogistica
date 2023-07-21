import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/login/services/auth.service';
@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  constructor(public loginService:AuthService){ }
  ngOnInit() {
  }

}
