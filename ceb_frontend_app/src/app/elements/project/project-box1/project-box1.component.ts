import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-project-box1',
  templateUrl: './project-box1.component.html',
  styleUrls: ['./project-box1.component.css']
})
export class ProjectBox1Component implements OnInit {

  @Input() project: any;
  
  constructor() { }

  ngOnInit(): void {
  }

}
