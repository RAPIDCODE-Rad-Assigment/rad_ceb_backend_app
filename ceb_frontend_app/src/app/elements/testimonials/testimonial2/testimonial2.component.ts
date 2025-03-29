import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-testimonial2',
  templateUrl: './testimonial2.component.html',
  styleUrls: ['./testimonial2.component.css']
})
export class Testimonial2Component implements OnInit {

  @Input() data: any;
  @Input() darkBack: any;
  
  constructor() { }

  ngOnInit(): void {
  }

}
