import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-project-full',
  templateUrl: './project-full.component.html',
  styleUrls: ['./project-full.component.css']
})
export class ProjectFullComponent implements OnInit {

  @Input() data: any;
  
  constructor() { }

  ngOnInit(): void {
  }

}
