import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-testimonial3',
  templateUrl: './testimonial3.component.html',
  styleUrls: ['./testimonial3.component.css']
})
export class Testimonial3Component implements OnInit {

  @Input() data: any;

  constructor() { }

  ngOnInit(): void {
  }

}
