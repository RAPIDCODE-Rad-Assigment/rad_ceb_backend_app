import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-testimonial4',
  templateUrl: './testimonial4.component.html',
  styleUrls: ['./testimonial4.component.css']
})
export class Testimonial4Component implements OnInit {

  @Input() data: any;
  
  constructor() { }

  ngOnInit(): void {
  }

}
