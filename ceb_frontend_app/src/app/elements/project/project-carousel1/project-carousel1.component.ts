import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-project-carousel1',
  templateUrl: './project-carousel1.component.html',
  styleUrls: ['./project-carousel1.component.css']
})
export class ProjectCarousel1Component implements OnInit {

  @Input() projects: any;
  
  constructor() { }

  ngOnInit(): void {
  }

}
