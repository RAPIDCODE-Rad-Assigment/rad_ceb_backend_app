import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-team5',
  templateUrl: './team5.component.html',
  styleUrls: ['./team5.component.css']
})
export class Team5Component implements OnInit {

  @Input() data: any;

  constructor() { }

  ngOnInit(): void {
  }

}
