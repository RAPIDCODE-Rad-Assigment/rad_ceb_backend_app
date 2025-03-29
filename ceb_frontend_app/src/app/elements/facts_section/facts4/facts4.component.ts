import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-facts4',
  templateUrl: './facts4.component.html',
  styleUrls: ['./facts4.component.css']
})
export class Facts4Component implements OnInit {

  @Input() data: any;
  
  constructor() { }

  ngOnInit(): void {
  }

}
