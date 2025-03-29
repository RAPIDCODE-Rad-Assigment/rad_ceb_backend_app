import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-updates1',
  templateUrl: './updates1.component.html',
  styleUrls: ['./updates1.component.css']
})
export class Updates1Component implements OnInit {

  @Input() data:any;

  constructor() { }

  ngOnInit(): void {
  }

}
