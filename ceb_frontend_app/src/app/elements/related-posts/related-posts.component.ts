import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-related-posts',
  templateUrl: './related-posts.component.html',
  styleUrls: ['./related-posts.component.css']
})
export class RelatedPostsComponent implements OnInit {

  @Input() data: any;
  constructor() { }

  ngOnInit(): void {
  }

}
