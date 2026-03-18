import { Component } from '@angular/core';
import { VehicleService } from '../../services/vehicle.service';

@Component({
  selector: 'app-view-vehicle',
  standalone: false,
  templateUrl: './view-vehicle.html',
  styleUrl: './view-vehicle.css',
})
export class ViewVehicle {
  userId : any;
  vehicleList : any;
  vehicle : any;
  vehicleNumber : any[] = [];
  
  constructor(private vehicleService : VehicleService) {}
  
  getByUserId() {

    this.vehicleList = [];
    this.vehicle = null;

    this.vehicleService.getByUserId(this.userId).subscribe(res => {
      this.vehicleList = res;
      console.log(res);
    });
  }
  
  getByVehicleNumber() {

    this.vehicleList = [];
    this.vehicle = null;
    
    this.vehicleService.getByVehicleNumber(this.vehicleNumber).subscribe(res => {
      this.vehicle = res;
      console.log(res);
    });
  }
  
}
