import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-testimonial1',
  templateUrl: './testimonial1.component.html',
  styleUrls: ['./testimonial1.component.css']
})
export class Testimonial1Component implements OnInit {

  @Input() data:any;

  constructor() { }

  ngOnInit(): void {
  }

}
