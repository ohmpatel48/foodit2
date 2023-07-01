import { Component } from '@angular/core';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css'],
})
export class SigninComponent {
  constructor() {}

  step = 1;
  selectedOption: string = 'user';
  User: string = 'user';
  Restaurant: string = 'Restaurant';
  Delivery: string = 'delivery';
  username: string = '';
  entered: boolean = true;
  validUsername: boolean = false;
  isPasswordVisible1 = false;
  passwordType1 = 'password';
  password: string = '';
  repatedpassword: string = '';
  validpassword: boolean = false;

  togglePasswordVisibility1() {
    this.isPasswordVisible1 = !this.isPasswordVisible1;
    this.passwordType1 = this.isPasswordVisible1 ? 'text' : 'password';
  }
  isPasswordVisible2 = false;
  passwordType2 = 'password';

  togglePasswordVisibility2() {
    this.isPasswordVisible2 = !this.isPasswordVisible2;
    this.passwordType2 = this.isPasswordVisible2 ? 'text' : 'password';
  }

  onNext() {
    if (this.username == '') {
      this.entered = true;
      this.validUsername = false;
    } else if (this.username.length <= 4) {
      window.alert('Username must be at least 5 characters long');
    } else {
      if (this.selectedOption == this.User) {
        this.step = 2;
      } else if (this.selectedOption == this.Restaurant) {
        this.step = 3;
      } else {
        this.step = 4;
      }
    }
  }
  checkUsernameAvailability() {
    if (this.username.length > 0) {
      this.entered = false;
    }
  }
  submit(
    Username: any,
    name: any,
    email: any,
    password: any,
    phone: any,
    city: any,
    street: any,
    house: any,
    zip: any
  ) {}
  checkPassword() {
    if (this.password == this.repatedpassword) {
      this.validpassword = true;
    } else {
    }
  }
}
