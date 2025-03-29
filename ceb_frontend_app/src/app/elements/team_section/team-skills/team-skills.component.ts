import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-team-skills',
  templateUrl: './team-skills.component.html',
  styleUrls: ['./team-skills.component.css']
})
export class TeamSkillsComponent implements OnInit {

  @Input() data: any;

  constructor() { }

  ngOnInit(): void {
  }

}
