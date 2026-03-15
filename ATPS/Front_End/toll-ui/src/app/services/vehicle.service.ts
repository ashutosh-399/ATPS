import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class VehicleService {

  constructor(private http: HttpClient) { }

  addVehicle(vehicleData: any): Observable<any> {
    return this.http.post('http://localhost:8082/vehicles/register', vehicleData);
  }
}