import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-about-section5',
  templateUrl: './about-section5.component.html',
  styleUrls: ['./about-section5.component.css']
})
export class AboutSection5Component implements OnInit {

  @Input() data: any;
  
  constructor() { }

  ngOnInit(): void {
  }

}
