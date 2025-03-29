import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-service-section1',
  templateUrl: './service-section1.component.html',
  styleUrls: ['./service-section1.component.css']
})
export class ServiceSection1Component implements OnInit {

  @Input() data: any;
  
  constructor() { }

  ngOnInit(): void {
  }

}
