import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-project-carousel2',
  templateUrl: './project-carousel2.component.html',
  styleUrls: ['./project-carousel2.component.css']
})
export class ProjectCarousel2Component implements OnInit {

  @Input() projects: any;
  
  constructor() { }

  ngOnInit(): void {
  }

}
