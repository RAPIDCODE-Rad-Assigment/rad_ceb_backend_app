import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-project-box4',
  templateUrl: './project-box4.component.html',
  styleUrls: ['./project-box4.component.css']
})
export class ProjectBox4Component implements OnInit {

  @Input() project: any;
  
  constructor() { }

  ngOnInit(): void {
  }

}
