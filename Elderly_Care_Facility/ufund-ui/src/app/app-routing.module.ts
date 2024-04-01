import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomepageComponent} from './homepage/homepage.component';
import { CartpageComponent } from './cart/cartpage.component';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';
import { AboutusComponent } from './aboutus/aboutus.component';
import {LoginComponent} from './login/login.component';
import {EditNeedComponent} from './edit-need/edit-need.component';
import { AdoptpageComponent } from './adopt/adoptpage.component';

const routes: Routes = [
  {path: '', redirectTo: '/aboutus', pathMatch: 'full'},
  {path: 'homepage', component: HomepageComponent},
  {path: 'cartpage', component: CartpageComponent},
  {path: 'aboutus', component: AboutusComponent},
  {path: 'login', component: LoginComponent},
  {path: 'edit-need', component: EditNeedComponent},
  {path: 'adoptpage', component: AdoptpageComponent}
];

@NgModule({
  declarations: [CartpageComponent],
  imports: [RouterModule.forRoot(routes), BrowserModule, CommonModule],
  exports: [RouterModule, BrowserModule]
})
export class AppRoutingModule { }
export class CartpageModule {}
