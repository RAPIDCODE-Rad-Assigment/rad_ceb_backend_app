import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-project-box3',
  templateUrl: './project-box3.component.html',
  styleUrls: ['./project-box3.component.css']
})
export class ProjectBox3Component implements OnInit {

  @Input() project: any;
  
  constructor() { }

  ngOnInit(): void {
  }

}
