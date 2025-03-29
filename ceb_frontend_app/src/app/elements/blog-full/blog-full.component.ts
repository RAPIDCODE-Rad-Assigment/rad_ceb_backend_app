import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-blog-full',
  templateUrl: './blog-full.component.html',
  styleUrls: ['./blog-full.component.css']
})
export class BlogFullComponent implements OnInit {

  @Input() data: any;

  constructor() { }

  ngOnInit(): void {
  }

}
