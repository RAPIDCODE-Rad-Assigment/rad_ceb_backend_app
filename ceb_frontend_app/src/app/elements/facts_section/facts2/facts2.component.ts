import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-facts2',
  templateUrl: './facts2.component.html',
  styleUrls: ['./facts2.component.css']
})
export class Facts2Component implements OnInit {

  @Input() data:any;

  constructor() { }

  ngOnInit(): void {
  }

}
