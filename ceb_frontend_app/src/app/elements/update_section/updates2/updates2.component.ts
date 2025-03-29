import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-updates2',
  templateUrl: './updates2.component.html',
  styleUrls: ['./updates2.component.css']
})
export class Updates2Component implements OnInit {

  @Input() data:any;

  constructor() { }

  ngOnInit(): void {
  }

}
