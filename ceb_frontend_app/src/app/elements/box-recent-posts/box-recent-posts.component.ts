import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-box-recent-posts',
  templateUrl: './box-recent-posts.component.html',
  styleUrls: ['./box-recent-posts.component.css']
})
export class BoxRecentPostsComponent implements OnInit {

  @Input() data: any;

  constructor() { }

  ngOnInit(): void {
  }

}
