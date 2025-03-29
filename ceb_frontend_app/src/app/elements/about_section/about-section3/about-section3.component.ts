import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-about-section3',
  templateUrl: './about-section3.component.html',
  styleUrls: ['./about-section3.component.css']
})
export class AboutSection3Component implements OnInit {

  @Input() data:any;

  constructor() { }

  ngOnInit(): void {
  }

}
