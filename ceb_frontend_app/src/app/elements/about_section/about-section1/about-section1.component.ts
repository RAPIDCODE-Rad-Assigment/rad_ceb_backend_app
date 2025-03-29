import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-about-section1',
  templateUrl: './about-section1.component.html',
  styleUrls: ['./about-section1.component.css']
})
export class AboutSection1Component implements OnInit {

  @Input() data:any;

  constructor() { }

  ngOnInit(): void {
  }

}
