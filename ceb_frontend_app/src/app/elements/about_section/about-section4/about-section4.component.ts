import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-about-section4',
  templateUrl: './about-section4.component.html',
  styleUrls: ['./about-section4.component.css']
})
export class AboutSection4Component implements OnInit {

  @Input() data: any;
  
  constructor() { }

  ngOnInit(): void {
  }

}
