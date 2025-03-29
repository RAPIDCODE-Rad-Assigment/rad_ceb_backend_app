import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-box-instagram',
  templateUrl: './box-instagram.component.html',
  styleUrls: ['./box-instagram.component.css']
})
export class BoxInstagramComponent implements OnInit {

  @Input() data: any;

  constructor() { }

  ngOnInit(): void {
  }

}
