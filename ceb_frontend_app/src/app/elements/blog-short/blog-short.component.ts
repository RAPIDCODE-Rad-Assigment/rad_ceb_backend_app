import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-blog-short',
  templateUrl: './blog-short.component.html',
  styleUrls: ['./blog-short.component.css']
})
export class BlogShortComponent implements OnInit {

  @Input() data: any;

  constructor() { }

  ngOnInit(): void {
  }

}
