import { Component, OnInit } from '@angular/core';
import { AccountType } from './accountType';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {

  constructor() { }

firstName:string="Test";
 accountType = [
  new AccountType(1, 'Checking' ),
  new AccountType(2, 'Saving' ),
  new AccountType(3, 'Credit' ),
  new AccountType(4, 'Mortgage'),
  new AccountType(5, 'CD')
];


  ngOnInit() {
  }

}
