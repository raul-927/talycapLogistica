
﻿import { Component,ComponentFactoryResolver, ViewChild,  OnInit, AfterViewInit, ChangeDetectorRef, OnChanges } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { AuthService } from '../../services/auth.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm?: FormGroup;
  submitted = false;
  returnUrl?: string;
  error?: string;
  loading = true;

  constructor(
    private cd: ChangeDetectorRef,
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private authServcice: AuthService,
    private componentFactoryResolver: ComponentFactoryResolver
  ) {
    this.cd.detach();
    // redirect to home if already logged in
    if (this.authServcice.currentUserValue) {
        this.router.navigate(['/']);
    }
}
ngAfterViewInit(){
  this.loading = false;
}

ngOnCanges(){
    if (this.authServcice.currentUserValue) {
        this.router.navigate(['/']);
    }
}
ngOnInit() {
  this.cd.reattach();
  this.loading = false;
  this.loginForm = this.formBuilder.group({
    username: ['', Validators.required],
    password: ['', Validators.required]
});
  // get return url from route parameters or default to '/'
  this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
}

 // convenience getter for easy access to form fields
 get f() { return this.loginForm?.controls; }

 onSubmit() {
     this.submitted = true;

     // stop here if form is invalid
     if (this.loginForm?.invalid) {
         return;
     }

     this.loading = true;
     this.authServcice.login(this.f?.['username'].value, this.f?.['password'].value)
         .pipe(first())
         .subscribe(
             data => {
              this.router.navigate(['/clientes']);
             },
             error => {
                 this.error = error;
                 this.loading = false;
             });
  }

  logout(){
    //sessionStorage.removeItem('token');
    //sessionStorage.removeItem('username');
    localStorage.removeItem('currentUser');
    this.router.navigate(['/login']);
  }

}
