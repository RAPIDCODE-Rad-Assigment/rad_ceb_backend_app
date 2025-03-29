import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-facts3',
  templateUrl: './facts3.component.html',
  styleUrls: ['./facts3.component.css']
})
export class Facts3Component implements OnInit {

  @Input() data: any;
  
  constructor() { }

  ngOnInit(): void {
  }

}
