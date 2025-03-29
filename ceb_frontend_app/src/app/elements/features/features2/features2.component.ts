import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-features2',
  templateUrl: './features2.component.html',
  styleUrls: ['./features2.component.css']
})
export class Features2Component implements OnInit {

  @Input() data:any;

  constructor() { }

  ngOnInit(): void {
  }

}
