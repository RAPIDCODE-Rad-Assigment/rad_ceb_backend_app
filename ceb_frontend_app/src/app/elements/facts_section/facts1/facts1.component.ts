import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-facts1',
  templateUrl: './facts1.component.html',
  styleUrls: ['./facts1.component.css']
})
export class Facts1Component implements OnInit {

  @Input() data:any;

  constructor() { }

  ngOnInit(): void {
  }

}
