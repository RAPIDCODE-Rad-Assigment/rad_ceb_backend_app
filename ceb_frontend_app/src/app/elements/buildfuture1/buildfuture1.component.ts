import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-buildfuture1',
  templateUrl: './buildfuture1.component.html',
  styleUrls: ['./buildfuture1.component.css']
})
export class Buildfuture1Component implements OnInit {

  @Input() data:any;

  constructor() { }

  ngOnInit(): void {
  }

}
