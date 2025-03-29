import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-team1',
  templateUrl: './team1.component.html',
  styleUrls: ['./team1.component.css']
})
export class Team1Component implements OnInit {

  @Input() data:any;

  constructor() { }

  ngOnInit(): void {
  }

}
