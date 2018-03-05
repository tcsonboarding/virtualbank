import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {ICustomer} from './customer';

@Injectable()
export class CustomerService {
    
  //private url: string = "http://localhost:8080/virtualbank/customers";

 private url: string = "https://api.myjson.com/bins/87fpl";
    
  constructor(private http: HttpClient) { }
  
  getCustomers(): Observable<ICustomer[]>{
      return this.http.get<ICustomer[]>(this.url);
  }

}
