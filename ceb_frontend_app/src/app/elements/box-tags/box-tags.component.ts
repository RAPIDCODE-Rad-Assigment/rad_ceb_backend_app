import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-box-tags',
  templateUrl: './box-tags.component.html',
  styleUrls: ['./box-tags.component.css']
})
export class BoxTagsComponent implements OnInit {

  @Input() data: any;

  constructor() { }

  ngOnInit(): void {
  }

}
