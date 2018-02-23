import { Component, OnInit } from '@angular/core';
import {Customer} from '../customer/customer';
import {CUSTOMERS} from '../customer/mocs-customers';

@Component({
  selector: 'app-viewallcustomers',
  templateUrl: './viewallcustomers.component.html',
  styleUrls: ['./viewallcustomers.component.css']
})
export class ViewallcustomersComponent implements OnInit {

  customers = CUSTOMERS;

  constructor() { }

  ngOnInit() {
  }

}
