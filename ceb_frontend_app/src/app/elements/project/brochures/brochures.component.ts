import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-brochures',
  templateUrl: './brochures.component.html',
  styleUrls: ['./brochures.component.css']
})
export class BrochuresComponent implements OnInit {

  @Input() data: any;

  constructor() { }

  ngOnInit(): void {
  }

}
