import { Component, OnInit } from '@angular/core';
import {CustomerService} from './customer.service';

@Component({
  selector: 'app-viewcustomers',
  templateUrl: './viewcustomers.component.html',
  styleUrls: ['./viewcustomers.component.css']
})
export class ViewcustomersComponent implements OnInit {

    vbcustomers = [];

  constructor(private customerService: CustomerService) { }

  ngOnInit() {
    this.customerService.getCustomers()
    .subscribe(data => this.vbcustomers = data);
  }

}
