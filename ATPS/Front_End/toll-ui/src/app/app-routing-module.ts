import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserControl } from './user-control/user-control';
import { TollControl } from './toll-control/toll-control';
import { VehicleControl } from './vehicle-control/vehicle-control';
import { AddVehicle } from './add-vehicle/add-vehicle';
import { WalletBalance } from './wallet-balance/wallet-balance';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'auth',
    pathMatch: 'full'
  },
  { 
    path: 'auth', 
    loadChildren: () => import('./auth/auth-module').then(m => m.AuthModule) 
  },
  {
    path: 'dashboard',
    loadChildren: () => import('./dashboard/dashboard-module').then(m => m.DashboardModule)
  },
  {
    path: 'userControl',
    component: UserControl
  },
  {
    path: 'tollControl',
    component: TollControl
  },
  {
    path: 'addVehicle',
    component: AddVehicle
  },
  {
    path: 'vehicleControl',
    component: VehicleControl
  },
  {
    path: 'walletBalance',
    component: WalletBalance
  }
  

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
