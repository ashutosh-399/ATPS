import { Component } from '@angular/core';
import { VehicleService } from '../services/vehicle.service';

@Component({
  selector: 'app-user-control',
  standalone: false,
  templateUrl: './user-control.html',
  styleUrl: './user-control.css',
})
export class UserControl {
  transactions: any;

  constructor(private vehicleService: VehicleService) {}

  addVehicle() {
    // Example: Replace with actual vehicle data
    const vehicleData = { /* your vehicle data here */ };
    this.vehicleService.addVehicle(vehicleData).subscribe(
      response => {
        console.log('Vehicle added successfully', response);
        // Handle success, e.g., show a message or navigate
      },
      error => {
        console.error('Error adding vehicle', error);
        // Handle error
      }
    );
  }
}
