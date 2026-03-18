import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { VehicleService } from '../services/vehicle.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-vehicle',
  standalone: false,
  templateUrl: './add-vehicle.html',
  styleUrl: './add-vehicle.css',
})
export class AddVehicle {

    addVehicleForm: FormGroup;
    successMessage = '';
    errorMessage = '';
    
    constructor(
      private fb: FormBuilder,
      private vehicleService: VehicleService,
      private router: Router
    ) {
      this.addVehicleForm = this.fb.group({
        userId:['', Validators.required],
        vehicleNumber: ['', Validators.required],
        vehicleType: ['', Validators.required],
        model: ['', Validators.required]
      });
    }

    onSubmit() {
      if (this.addVehicleForm.valid) {
        this.vehicleService.addVehicle(this.addVehicleForm.value).subscribe({
          next: (res) => {
            this.successMessage = 'Vehicle added successfully!';

            setTimeout( () => {
              this.router.navigate(['/dashboard']);
            }, 1000);
          },
          error: () => {
            this.errorMessage = 'Error adding vehicle.';
          }
        });
      }
    }
  }
