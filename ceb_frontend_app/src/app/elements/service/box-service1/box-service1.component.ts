import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-box-service1',
  templateUrl: './box-service1.component.html',
  styleUrls: ['./box-service1.component.css']
})
export class BoxService1Component implements OnInit {

  @Input() data: any;
  
  constructor() { }

  ngOnInit(): void {
  }

}
