import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-team3',
  templateUrl: './team3.component.html',
  styleUrls: ['./team3.component.css']
})
export class Team3Component implements OnInit {

  @Input() data:any;
  @Input() width:any;

  constructor() { }

  ngOnInit(): void {
  }

}
