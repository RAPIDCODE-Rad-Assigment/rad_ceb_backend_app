import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-project-box2',
  templateUrl: './project-box2.component.html',
  styleUrls: ['./project-box2.component.css']
})
export class ProjectBox2Component implements OnInit {

  @Input() project: any;
  
  constructor() { }

  ngOnInit(): void {
  }

}
