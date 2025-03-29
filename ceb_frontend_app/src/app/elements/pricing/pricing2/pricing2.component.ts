import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-pricing2',
  templateUrl: './pricing2.component.html',
  styleUrls: ['./pricing2.component.css']
})
export class Pricing2Component implements OnInit {

  @Input() data: any;
  
  constructor() { }

  ngOnInit(): void {
  }

}
