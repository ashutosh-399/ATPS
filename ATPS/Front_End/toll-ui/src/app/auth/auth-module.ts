import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Login } from './login/login';
import { ReactiveFormsModule } from '@angular/forms';
import { Signup } from './signup/signup';
import { RouterLink, RouterModule, RouterOutlet, Routes } from '@angular/router';

const routes: Routes = [
  { path: '',
    redirectTo: 'login',
    pathMatch: 'full'
  },
  { 
    path: 'login',
    component: Login
  },
  { path: 'signup',
    component: Signup
  }
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    RouterOutlet,
    RouterLink,
    RouterModule.forChild(routes)    
  ]
})
export class AuthModule { }
