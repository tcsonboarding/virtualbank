import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AccountComponent } from '../account/account.component';
import {CreditscoreComponent} from '../creditscore/creditscore.component';
import {BillpayComponent} from '../billpay/billpay.component';
import {CustomerComponent} from '../customer/customer.component';
import {LoginComponent} from '../login/login.component';
import {AddcustomerComponent} from '../addcustomer/addcustomer.component';
import {SearchcustomerComponent} from '../searchcustomer/searchcustomer.component';
import {ViewallcustomersComponent} from '../viewallcustomers/viewallcustomers.component';


const appRoutes = [

    {path:'', redirectTo:'/login', pathMatch: 'full'},
    {path:'accounts', component:AccountComponent},
    {path:'customer', component:CustomerComponent},
    {path:'customer/add', component:AddcustomerComponent},
    {path:'customer/search', component:SearchcustomerComponent},
    {path:'customer/view', component:ViewallcustomersComponent},
    {path:'billpay', component:BillpayComponent},
    {path:'creditscore', component:CreditscoreComponent},
    {path:'login', component:LoginComponent}
];
@NgModule({
    imports: [RouterModule.forRoot(appRoutes)],
     exports: [RouterModule]
})

export class AppRoutingModule {

}