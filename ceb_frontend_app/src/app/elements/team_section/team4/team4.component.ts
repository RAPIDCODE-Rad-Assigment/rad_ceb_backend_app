import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-team4',
  templateUrl: './team4.component.html',
  styleUrls: ['./team4.component.css']
})
export class Team4Component implements OnInit {

  @Input() data:any;
  @Input() back: any;

  constructor() { }

  ngOnInit(): void {
  }

}
