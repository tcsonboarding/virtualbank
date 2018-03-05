import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
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
import { ViewcustomersComponent } from './viewcustomers/viewcustomers.component';
import { CustomerService } from './viewcustomers/customer.service';


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
    ViewallcustomersComponent,
    ViewcustomersComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [CustomerService],
  bootstrap: [AppComponent]
})
export class AppModule { }