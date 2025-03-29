import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-facts5',
  templateUrl: './facts5.component.html',
  styleUrls: ['./facts5.component.css']
})
export class Facts5Component implements OnInit {

  @Input() data: any;
  
  constructor() { }

  ngOnInit(): void {
  }

}
