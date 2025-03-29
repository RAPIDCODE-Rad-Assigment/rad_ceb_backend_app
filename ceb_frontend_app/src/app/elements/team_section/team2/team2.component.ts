import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-team2',
  templateUrl: './team2.component.html',
  styleUrls: ['./team2.component.css']
})
export class Team2Component implements OnInit {

  @Input() data:any;

  constructor() { }

  ngOnInit(): void {
  }

}
