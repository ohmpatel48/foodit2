import { Component } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
constructor() { }
user : any = {};
login(typeEmailX: any, typePasswordX: any){
  this.user.email = typeEmailX;
  this.user.password = typePasswordX;
    
}
}
