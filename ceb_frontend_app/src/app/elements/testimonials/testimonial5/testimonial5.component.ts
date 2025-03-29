import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-testimonial5',
  templateUrl: './testimonial5.component.html',
  styleUrls: ['./testimonial5.component.css']
})
export class Testimonial5Component implements OnInit {

  @Input() data: any;
  
  constructor() { }

  ngOnInit(): void {
  }

}
