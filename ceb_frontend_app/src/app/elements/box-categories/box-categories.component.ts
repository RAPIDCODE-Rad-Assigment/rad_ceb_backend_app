import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-box-categories',
  templateUrl: './box-categories.component.html',
  styleUrls: ['./box-categories.component.css']
})
export class BoxCategoriesComponent implements OnInit {

  @Input() data: any;

  constructor() { }

  ngOnInit(): void {
  }

}
