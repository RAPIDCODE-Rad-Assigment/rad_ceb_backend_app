import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-ourclients1',
  templateUrl: './ourclients1.component.html',
  styleUrls: ['./ourclients1.component.css']
})
export class Ourclients1Component implements OnInit {

  @Input() data:any;

  constructor() { }

  ngOnInit(): void {
  }

}
