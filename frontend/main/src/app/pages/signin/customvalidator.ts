import { AbstractControl,ValidatorFn,FormGroup,FormControlName } from "@angular/forms";

export function UsernameValidator(): ValidatorFn {
    return (control: AbstractControl): {[key: string]: boolean} | null => {
        if (control.value.trim == '') {
            return {'Username is already taken': true};
        }
        else {
            return null;
        }
    }
}
