import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';


import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';
import { AccountComponent } from './account/account.component';
import { CustomerComponent } from './customer/customer.component';
import { BillpayComponent } from './billpay/billpay.component';
import { CreditscoreComponent } from './creditscore/creditscore.component';
import { AppRoutingModule} from './routing-module/app-routing.module';
import { LoginComponent } from './login/login.component';
import { AddcustomerComponent } from './addcustomer/addcustomer.component';
import { SearchcustomerComponent } from './searchcustomer/searchcustomer.component';
import { ViewallcustomersComponent } from './viewallcustomers/viewallcustomers.component';


@NgModule({
  declarations: [
    AppComponent,
    AccountComponent,
    CustomerComponent,
    BillpayComponent,
    CreditscoreComponent,
    NavbarComponent,
    FooterComponent,
    LoginComponent,
    AddcustomerComponent,
    SearchcustomerComponent,
    ViewallcustomersComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }


/*
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';


import { AppComponent } from './app.component';
import { AccountComponent } from './account/account.component';
import { CustomerComponent } from './customer/customer.component';
import { BillpayComponent } from './billpay/billpay.component';
import { CreditscoreComponent } from './creditscore/creditscore.component';
import { AppRoutingModule} from './routing-module/app-routing.module';
import { AccountType} from './account/accountType';

@NgModule({
  declarations: [
    AppComponent,
    AccountComponent,
    CustomerComponent,
    BillpayComponent,
    CreditscoreComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

*/