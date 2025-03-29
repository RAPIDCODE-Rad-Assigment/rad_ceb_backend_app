import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-about-section6',
  templateUrl: './about-section6.component.html',
  styleUrls: ['./about-section6.component.css']
})
export class AboutSection6Component implements OnInit {

  @Input() data: any;
  
  constructor() { }

  ngOnInit(): void {
  }

}
