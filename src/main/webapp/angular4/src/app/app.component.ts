import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  roomsearch: FormGroup;
  rooms: Room[]  
    ngOnInit(){
        this.roomsearch = new FormGroup({
            checkin : new FormControl(''),
            checkout : new FormControl('')   
        });
        this.rooms = ROOMS;
    }
    
    onSubmit(value){
       console.log(value);     
    }
    
    reserveRoom(value:string){
        console.log(value);     
   }
}
export interface Room {
    id: string;
    roomNumber: string;
    price: string;
    links: string;
}
var ROOMS: Room[] = [
    {
        "id": "12454",
        "roomNumber": "201",
        "price": "66.69",
        "links": ""
    }, {
        "id": "12452",
        "roomNumber": "202",
        "price": "68.69",
        "links": ""
    }, {
        "id": "12444",
        "roomNumber": "203",
        "price": "66.69",
        "links": ""
    }

]
