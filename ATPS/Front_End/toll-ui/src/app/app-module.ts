import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { Login } from './auth/login/login';
import { Home } from './dashboard/home/home';
import { Signup } from './auth/signup/signup';
import { RouterLink } from '@angular/router';
import { UserControl } from './user-control/user-control';
import { TollControl } from './toll-control/toll-control';
import { VehicleControl } from './vehicle-control/vehicle-control';
import { AddVehicle } from './add-vehicle/add-vehicle';
import { WalletBalance } from './wallet-balance/wallet-balance';

@NgModule({
  declarations: [
    App,
    Login,
    Signup,
    UserControl,
    TollControl,
    VehicleControl,
    AddVehicle,
    WalletBalance
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    RouterLink
  ],
  providers: [
    provideBrowserGlobalErrorListeners()
  ],
  bootstrap: [App]
})
export class AppModule { }
