import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-team-profile',
  templateUrl: './team-profile.component.html',
  styleUrls: ['./team-profile.component.css']
})
export class TeamProfileComponent implements OnInit {

  @Input() profile: any;
  
  constructor() { }

  ngOnInit(): void {
  }

}
