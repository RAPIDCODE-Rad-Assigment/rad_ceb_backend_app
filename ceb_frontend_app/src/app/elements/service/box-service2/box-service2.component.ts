import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-box-service2',
  templateUrl: './box-service2.component.html',
  styleUrls: ['./box-service2.component.css']
})
export class BoxService2Component implements OnInit {

  @Input() data: any;
  
  constructor() { }

  ngOnInit(): void {
  }

}
