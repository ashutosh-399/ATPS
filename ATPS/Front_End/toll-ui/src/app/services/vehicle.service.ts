import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class VehicleService {

  private baseUrl = environment.vehicleServiceUrl;

  constructor(private http: HttpClient) { }

  addVehicle(vehicleData: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/vehicles/register`, vehicleData);
  }

  getByUserId(userId: number) {
    return this.http.post(`${this.baseUrl}/vehicles/getByUserId/` + userId, {});
  }

  getByVehicleNumber(vehicleNumber: any) {
    return this.http.get(`${this.baseUrl}/vehicles/getByVehicleNumber/` + vehicleNumber);
  }

}