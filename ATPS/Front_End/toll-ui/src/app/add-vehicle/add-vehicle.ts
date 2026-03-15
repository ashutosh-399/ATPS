import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-add-vehicle',
  standalone: false,
  templateUrl: './add-vehicle.html',
  styleUrl: './add-vehicle.css',
})
export class AddVehicle {

  addVehicleForm: FormGroup;

  constructor(
    private fb: FormBuilder
  ) {
    this.addVehicleForm = this.fb.group({
      userId:['', Validators.required],
      vehicleNumber: ['', Validators.required],
      vehicleType: ['', Validators.required],
      model: ['', Validators.required]
    });
  }

  onSubmit() {
    
  }
}
