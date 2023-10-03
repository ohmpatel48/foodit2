import { Component } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { CurrentLocationMapComponent } from 'src/app/components/current-location-map/current-location-map.component';
import { GeocodingServicesService } from 'src/app/services/geocoding-services.service';
import { UsernameValidator } from './customvalidator';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css'],
})
export class SigninComponent {
  firstFormGroup = this._formBuilder.group({
    UsernameValidator: ['', Validators.required],
  });
  secondFormGroup = this._formBuilder.group({
    Email: ['', [Validators.required, Validators.email]],
    Verification_code: [
      '',
      [Validators.required, Validators.minLength(6), Validators.maxLength(6)],
    ],
  });
  thirdFormGroup = this._formBuilder.group(
    {
      firstCtrl: ['', Validators.required],
      lastCtrl: ['', Validators.required],
      number: [
        '',
        [
          Validators.required,
          Validators.minLength(10),
          Validators.maxLength(10),
        ],
      ],
      password: [
        '',
        [
          Validators.required,
          Validators.minLength(8),
          Validators.maxLength(16),
        ],
      ],
      repeatPassword: [
        '',
        [
          Validators.required,
          Validators.minLength(8),
          Validators.maxLength(16),
        ],
      ],
    },
    {
      Validators: this.checkPassword('password', 'repeatPassword'),
    }
  );
  fourthFormGroup = this._formBuilder.group({
    buildingnumber: ['', Validators.required],
    street: ['', Validators.required],
    city: ['', Validators.required],
    state: ['', Validators.required],
    country: ['', Validators.required],
    pincode: [
      '',
      [Validators.required, Validators.minLength(6), Validators.maxLength(6)],
    ],
  });

  isLinear = true; // to set jumping between step
  send = false; // is to visbility of the validation code field
  isInputDisabled = false; // is to set email field to be disabled
  User_type: string = 'Normal'; // get the user type
  User_types: string[] = ['Normal', 'Restaurant', 'Delivery']; // user types array
  repeatPasswordcheck: any = false; // to check the password and repeat password
  user = {
    username: '',
    typeofuser: '',
    email: '',
    firstname: '',
    lastname: '',
    phone: '',
    password: '',
    buildingnumber: '',
    street: '',
    city: '',
    state: '',
    country: '',
    pincode: '',
    longitude: '',
    latitude: '',
  };
  constructor(
    private _formBuilder: FormBuilder,
    private _snackBar: MatSnackBar,
    public dialog: MatDialog,
    private geocoding: GeocodingServicesService
  ) {}

  sendmail(Email: any) {
    this.user.email = Email;
    if (this.secondFormGroup.controls['Email'].errors == null) {
      this.isInputDisabled = true;
      this.send = true;
      this._snackBar.open('Email sent ', 'close');
    }
  }
  open(
    Username: any,
    Firstname: any,
    Lastname: any,
    Phone: any,
    buildingnumber: any,
    street: any,
    city: any,
    state: any,
    country: any,
    pincode: any
  ) {
    this.user.username = Username;
    this.user.firstname = Firstname;
    this.user.lastname = Lastname;
    this.user.phone = Phone;
    this.user.typeofuser = this.User_type;
    this.user.buildingnumber = buildingnumber;
    this.user.street = street;
    this.user.city = city;
    this.user.state = state;
    this.user.country = country;
    this.user.pincode = pincode;
    const dialogRef = this.dialog.open(CurrentLocationMapComponent, {
      data: { latitude: this.user.latitude, longitude: this.user.longitude },
    });
    dialogRef.afterClosed().subscribe((result) => {
      this.user.longitude = result.longitude;
      this.user.latitude = result.latitude;
      this.submit();
    });
  }
  submit() {
    
  }

  checkPassword(password: any, repeatPassword: any) {
    return (form: FormGroup) => {
      const passwordcontrol = form.controls['password'];
      const repeatPasswordcontrol = form.controls['repeatPassword'];
      if (passwordcontrol.errors && !repeatPasswordcontrol.errors) {
        return;
      } 
      if (passwordcontrol.value !== repeatPasswordcontrol.value) {
        repeatPasswordcontrol.setErrors({ checkPassword: true });
      } else {
        repeatPasswordcontrol.setErrors(null);
      }
    };
  }
  passwordcheck(password: any, repeatPassword: any) {
    if (password == repeatPassword) {
      this.repeatPasswordcheck = true;
    }else{
      this.repeatPasswordcheck = false;
    }
  }
}
