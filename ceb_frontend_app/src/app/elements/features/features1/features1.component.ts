import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-features1',
  templateUrl: './features1.component.html',
  styleUrls: ['./features1.component.css']
})
export class Features1Component implements OnInit {

  @Input() data: any;
  @Input() padding: any;

  constructor() { }

  ngOnInit(): void {
  }

}
