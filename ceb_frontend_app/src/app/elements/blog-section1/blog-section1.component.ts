import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-blog-section1',
  templateUrl: './blog-section1.component.html',
  styleUrls: ['./blog-section1.component.css']
})
export class BlogSection1Component implements OnInit {

  @Input() data: any;
  
  constructor() { }

  ngOnInit(): void {
  }

}
