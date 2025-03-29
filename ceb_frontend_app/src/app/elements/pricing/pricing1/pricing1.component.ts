import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-pricing1',
  templateUrl: './pricing1.component.html',
  styleUrls: ['./pricing1.component.css']
})
export class Pricing1Component implements OnInit {

  @Input() data: any;
  
  constructor() { }

  ngOnInit(): void {
  }

}
